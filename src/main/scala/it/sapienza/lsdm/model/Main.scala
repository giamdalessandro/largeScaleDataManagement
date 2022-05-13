package it.sapienza.lsdm.model

import slick.jdbc.PostgresProfile.api._

import org.apache.spark.sql.DataFrame

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import slick.lifted.AbstractTable
import org.apache.spark.sql.Encoders

object Main {
    val db = Database.forConfig("relationaldb")

    def init(): Unit = {
        val playerTable = TableQuery[PlayerEntity]

        val setup = DBIO.seq(
            // Create the tables, including primary and foreign keys
            (playerTable.schema).create,
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
}