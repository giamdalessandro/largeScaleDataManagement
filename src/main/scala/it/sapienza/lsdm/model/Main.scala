package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._
import slick.lifted.AbstractTable

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Encoders

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration


object Main {
    val db = Database.forConfig("relationaldb")

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
        var table = TableQuery[PlaysInEntity]
        var tableEncoder = Encoders.product[PlaysIn]
            
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

}