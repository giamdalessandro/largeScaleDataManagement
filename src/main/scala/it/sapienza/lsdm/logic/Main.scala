package it.sapienza.lsdm.logic

import org.apache.spark.sql.{SparkSession, DataFrame, Encoder, Dataset}
import it.sapienza.lsdm.App.{INPUT_PATH, OUTPUT_PATH}
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main {
    val db = Database.forConfig("relationaldb")

    def load_data(sparkSession: SparkSession): Unit = {
        val fbrefGcaDf          = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-gca-extraction.csv")
        val fbrefDefenseDf      = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-defense-extraction.csv")
        val fbrefInfoDf         = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-info-extraction.csv")
        val fbrefKeeperDf       = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-keeper-extraction.csv")
        val fbrefMiscDf         = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-misc-extraction.csv")
        val fbrefPassingDf      = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-passing-extraction.csv")
        val fbrefPlayingTimeDf  = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-playing_time-extraction.csv")
        val fbrefPossessionDf   = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-possession-extraction.csv")
        val fbrefShootingDf     = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-shooting-extraction.csv")
        val fbrefStandardDf     = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-standard-extraction.csv")
        val fm20Df              = read_csv_to_df(sparkSession, INPUT_PATH + "fm20-extraction.csv")

        fbrefGcaDf          .createOrReplaceTempView("FbrefGca")
        fbrefDefenseDf      .createOrReplaceTempView("FbrefDefense")
        fbrefInfoDf         .createOrReplaceTempView("FbrefInfo")
        fbrefKeeperDf       .createOrReplaceTempView("FbrefKeeper")
        fbrefMiscDf         .createOrReplaceTempView("FbrefMisc")
        fbrefPassingDf      .createOrReplaceTempView("FbrefPassing")
        fbrefPlayingTimeDf  .createOrReplaceTempView("FbrefPlayingTime")
        fbrefPossessionDf   .createOrReplaceTempView("FbrefPossession")
        fbrefShootingDf     .createOrReplaceTempView("FbrefShooting")
        fbrefStandardDf     .createOrReplaceTempView("FbrefStandard")
        fm20Df              .createOrReplaceTempView("Fm20")
    }

    /**
     * Reads a `.csv` file into a Spark.DataFrame.
     */
    def read_csv_to_df(sparkSession: SparkSession, path: String): DataFrame = {
        sparkSession.read
            .option("header", "true")
            .csv(path)
            .toDF()
    }

    /**
     * Writes a Spark.DataFrame into a `.csv` file.
     */
    def write_df_to_csv(dataframe: DataFrame, entityName: String): Unit = {
        dataframe
            .write
            .mode("overwrite")
            .option("header", "true")
            .csv(s"${OUTPUT_PATH}$entityName")
    }

    /**
     * Writes a Spark.DataFrame into a `.parquet` file.
     */
    def write_data_to_parquet[T](dataset: Dataset[T], entityName: String): Unit = {
        dataset
            .write
            .mode("overwrite")
            .parquet(s"${OUTPUT_PATH}$entityName")
    }

    /**
      * Converts a given dataframe to a list containing the same records
      *
      * @param dataframe
      * @param encoder
      * @return
      */
    def dataframe_to_list[T](dataframe: DataFrame, encoder: Encoder[T]): List[T] = {        
        return dataframe.as(encoder).collect.toList
    }

    //XXX Not working: problems with generics in Scala
    def create_table_if_not_exists[T](table: TableQuery[Table[T]]): Unit = {
        val future = db.run(table.schema.createIfNotExists)
        try {
            Await.result(future, Duration.Inf)
        } finally db.close
    }

    //XXX Not working: problems with generics in Scala
    def insert_list_into_table[T](list: List[Table[T]#TableElementType], table: TableQuery[Table[T]]): Unit = {
        val future = db.run(table ++= list)
        try {
            Await.result(future, Duration.Inf)
        } finally db.close
    }
  
}
