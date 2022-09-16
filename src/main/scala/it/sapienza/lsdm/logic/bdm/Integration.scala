package it.sapienza.lsdm.logic.bdm

import it.sapienza.lsdm.App.SQL_PATH
import it.sapienza.lsdm.App.OUTPUT_PATH

import it.sapienza.lsdm.model.bdm.PlayerOffensiveAbilityNR

import org.apache.spark.sql.{SparkSession, DataFrame, Encoders, Row}
import slick.jdbc.PostgresProfile.api._
import it.sapienza.lsdm.model.bdm._

import it.sapienza.lsdm.logic.Main._
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import org.apache.spark.sql.functions._

object Integration {
    private final val SQL_PATH_BDM = SQL_PATH + "bdm/"

    def DFM_to_DW(sparkSession: SparkSession): Unit = {
        var sqlString: String = null

        /**
         * OffensivePerformance Fact
         */

        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformanceFull.sql").mkString
        var offensivePerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        offensivePerformanceFullDf = offensivePerformanceFullDf.withColumn("id", monotonically_increasing_id())
        offensivePerformanceFullDf.createOrReplaceTempView("OffensivePerformanceFull")
        write_df_to_csv(offensivePerformanceFullDf, "OffensivePerformanceFull")//XXX debugging

        // PlayerOffensiveAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerOffensiveAbilityNR.sql").mkString
        val playerOffAbDf = sparkSession.sql(sqlString)
        import sparkSession.implicits._
        val nestedDataset = playerOffAbDf.map(r => player_offensive_ability_mapper(r))
        write_data_to_parquet(nestedDataset, "PlayerOffensiveAbility")

        // Birth Dimension
        val birthTable = TableQuery[BirthEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "Birth.sql").mkString
        var birthDf: DataFrame = sparkSession.sql(sqlString)
        birthDf = birthDf.withColumn("id", monotonically_increasing_id())
        birthDf.createOrReplaceTempView("Birth")
        write_df_to_csv(birthDf, "Birth")//XXX debugging
        val birthList = dataframe_to_list(birthDf, Encoders.product[Birth])

        // Organization Dimension
        val organizationTable = TableQuery[OrganizationEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "Organization.sql").mkString
        var organizationDf: DataFrame = sparkSession.sql(sqlString)
        organizationDf = organizationDf.withColumn("id", monotonically_increasing_id())
        organizationDf.createOrReplaceTempView("Organization")
        write_df_to_csv(organizationDf, "Organization")//XXX debugging
        val organizationList = dataframe_to_list(organizationDf, Encoders.product[Organization])

        // OffensivePerformance Measures
        val offensivePerformanceTable = TableQuery[OffensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformance.sql").mkString
        val offensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(offensivePerformanceDf, "OffensivePerformance")//XXX debugging
        val offensivePerformanceList = dataframe_to_list(offensivePerformanceDf, Encoders.product[OffensivePerformance])

        val op = DBIO.seq(
            birthTable.schema.dropIfExists,
            birthTable.schema.create,
            birthTable ++= birthList,

            organizationTable.schema.dropIfExists,
            organizationTable.schema.create,
            organizationTable ++= organizationList,

            // offensivePerformanceTable.schema.dropIfExists,
            offensivePerformanceTable.schema.create,
            offensivePerformanceTable ++= offensivePerformanceList
        )
        val future = db.run(op)
        try {
            Await.result(future, Duration.Inf)
        } finally db.close
    }

    def integrate_to_NR(sparkSession: SparkSession, entityName: String): Unit = {
        val sqlString: String = scala.io.Source.fromFile(SQL_PATH + entityName + ".sql").mkString
        val dataframe = sparkSession.sql(sqlString)

        import sparkSession.implicits._
        val nestedDataframe = dataframe.map(r => {
            PlayerNR(
                PersonalData(r.getString(0)),
                FootballData(r.getString(1), r.getString(2)))
        })

        nestedDataframe
            .write
            .mode("overwrite")
            .parquet(s"${OUTPUT_PATH}$entityName")
        // nestedDataframe
        //     .write
        //     .mode("overwrite")
        //     .json(s"${OUTPUT_PATH}$entityName")
    }

    private def player_offensive_ability_mapper(r: Row): PlayerOffensiveAbilityNR = {
        PlayerOffensiveAbilityNR(
            r.getLong(0),
            r.getString(1),
            r.getInt(2),
            MentalAbility(r.getInt(3)),
            PhysicalAbility(r.getInt(4)),
            TechnicalAbility(r.getInt(5), r.getInt(6))
        )
    }

}