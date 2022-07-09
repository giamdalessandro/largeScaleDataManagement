package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._
import slick.lifted.AbstractTable

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Encoders

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import org.apache.spark.sql.SparkSession


object Main {
    private final val INPUT_PATH = "src/main/scala/it/sapienza/lsdm/input/"
    private final val SQL_PATH = "src/main/scala/it/sapienza/lsdm/sparksql/"

    val db = Database.forConfig("relationaldb")

    /**
     * Reads a `.csv` file into a Spark.DataFrame.
     */
    def read_csv_to_df(sparkSession: SparkSession, filename: String): DataFrame = {
        sparkSession.read
            .option("header", "true")
            .csv(INPUT_PATH+filename)
            .toDF()
    }

    def init(): Unit = {
        val playerTable = TableQuery[PlayerEntity]

        val setup = DBIO.seq(
            // Create the tables, including primary and foreign keys
            (playerTable.schema).create
        )

        val setupFuture = db.run(setup)
        try {
            Await.result(setupFuture, Duration.Inf)
        } finally db.close
    }

    def insert(table: TableQuery[PlayerEntity], dataframe: DataFrame): Unit = {
        val playerEncoder = Encoders.product[Player]

        val playerDataset = dataframe.as(playerEncoder)
        val playerList = playerDataset.collect.toList

        val statement = table ++= playerList
        // val statement = DBIO.seq(
        //     table ++= playerList
        // )

        val statementFuture = db.run(statement)
        try {
            Await.result(statementFuture, Duration.Inf)
        } finally db.close
    }

    /**
    * Creates a TableQuery from a Spark.Dataframe and writes it, only if not exists, on the DB.
    */
    def init_and_populate(dataframe: DataFrame) : Unit = {
        var table = TableQuery[GoalkeeperStatsEntity]
        var tableEncoder = Encoders.product[GoalkeeperStats]
            
        var tableDataset = dataframe.as(tableEncoder)
        val tableList = tableDataset.collect.toList

        val setup = DBIO.seq(
            // Create the table, including primary and foreign keys
            (table.schema).create,
            // populates table
            table ++= tableList
        )

        val setupFuture = db.run(setup)
        try {
            Await.result(setupFuture, Duration.Inf)
        } finally db.close
    }

    /**
    * Reads the data from `filename` and create a table on DB with the query `sparksql`
    * on the `view_name` inside the sparksession `spark_sess`.
    */
    def load_and_insert(spark_sess: SparkSession, filename: String, view_name: String, sparksql: String) : Unit = {
        // read data as SparkDataFrame
        val fbrefDf = read_csv_to_df(spark_sess, filename)

        // create view inside SparkSession
        fbrefDf.createTempView(view_name)

        // add a table to DB
        val sqlString: String = scala.io.Source.fromFile(SQL_PATH+sparksql).mkString
        val tableDf = spark_sess.sql(sqlString)
        init_and_populate(tableDf)
    }

}