package it.sapienza.lsdm.logic.bdm

import it.sapienza.lsdm.App.SQL_PATH
import it.sapienza.lsdm.App.OUTPUT_PATH

import it.sapienza.lsdm.model.bdm.{PlayerOffensiveAbilityNR,PlayerDefensiveAbilityNR,PlayerGoalkeeperAbilityNR,PlayerPlaymakingAbilityNR}

import org.apache.spark.sql.{SparkSession, DataFrame, Encoders, Row}
import slick.jdbc.PostgresProfile.api._
import it.sapienza.lsdm.model.bdm._

import it.sapienza.lsdm.logic.Main._
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import org.apache.spark.sql.functions._
import it.sapienza.lsdm.model.relational.GoalkeeperAbility
import org.apache.hadoop.shaded.org.eclipse.jetty.websocket.common.frames

object Integration {
    private final val SQL_PATH_BDM = SQL_PATH + "bdm/"

    def DFM_to_DW(sparkSession: SparkSession): Unit = {
        var sqlString: String = null

        /**
         * OffensivePerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformanceFull.sql").mkString
        var offensivePerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        offensivePerformanceFullDf = offensivePerformanceFullDf.withColumn("id", monotonically_increasing_id())
        offensivePerformanceFullDf.createOrReplaceTempView("OffensivePerformanceFull")
        write_df_to_csv(offensivePerformanceFullDf, "OffensivePerformanceFull")//XXX debugging

        /**
         * DefensivePerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensivePerformanceFull.sql").mkString
        var defensivePerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        defensivePerformanceFullDf = defensivePerformanceFullDf.withColumn("id", monotonically_increasing_id())
        defensivePerformanceFullDf.createOrReplaceTempView("DefensivePerformanceFull")
        write_df_to_csv(defensivePerformanceFullDf, "DefensivePerformanceFull")//XXX debugging

        /**
         * GoalkeeperPerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperPerformanceFull.sql").mkString
        var goalkeeperPerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        goalkeeperPerformanceFullDf = goalkeeperPerformanceFullDf.withColumn("id", monotonically_increasing_id())
        goalkeeperPerformanceFullDf.createOrReplaceTempView("GoalkeeperPerformanceFull")
        write_df_to_csv(goalkeeperPerformanceFullDf, "GoalkeeperPerformanceFull")//XXX debugging

        /**
         * PlaymakingPerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingPerformanceFull.sql").mkString
        var playmakingPerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        playmakingPerformanceFullDf = playmakingPerformanceFullDf.withColumn("id", monotonically_increasing_id())
        playmakingPerformanceFullDf.createOrReplaceTempView("PlaymakingPerformanceFull")
        write_df_to_csv(playmakingPerformanceFullDf, "PlaymakingPerformanceFull")//XXX debugging

        /**
         * Dimensions
         */

        // PlayerOffensiveAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerOffensiveAbilityNR.sql").mkString
        val playerOffAbDf = sparkSession.sql(sqlString)
        import sparkSession.implicits._
        val offNestedDataset = playerOffAbDf.map(r => player_offensive_ability_mapper(r))
        write_data_to_parquet(offNestedDataset, "PlayerOffensiveAbility")

        // PlayerDefensiveAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerDefensiveAbilityNR.sql").mkString
        val playerDefAbDf = sparkSession.sql(sqlString)
        import sparkSession.implicits._
        val defNestedDataset = playerDefAbDf.map(r => player_defensive_ability_mapper(r))
        write_data_to_parquet(defNestedDataset, "PlayerDefensiveAbility")

        // PlayerGoalkeeperAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerGoalkeeperAbilityNR.sql").mkString
        val playerGkAbDf = sparkSession.sql(sqlString)
        import sparkSession.implicits._
        val gkNestedDataset = playerGkAbDf.map(r => player_goalkeeper_ability_mapper(r))
        write_data_to_parquet(gkNestedDataset, "PlayerGoalkeeperAbility")

        // PlayerPlaymakingAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerPlaymakingAbilityNR.sql").mkString
        val playerPmAbDf = sparkSession.sql(sqlString)
        import sparkSession.implicits._
        val pmNestedDataset = playerPmAbDf.map(r => player_playmaking_ability_mapper(r))
        write_data_to_parquet(pmNestedDataset, "PlayerPlaymakingAbility")

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

        System.out.println(">>> Dimension tables loaded.")

        /**
         * Fact Measures
         */

        // OffensivePerformance Measures
        val offensivePerformanceTable = TableQuery[OffensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformance.sql").mkString
        val offensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(offensivePerformanceDf, "OffensivePerformance")//XXX debugging
        val offensivePerformanceList = dataframe_to_list(offensivePerformanceDf, Encoders.product[OffensivePerformance])

        // DefensivePerformance Measures
        val defensivePerformanceTable = TableQuery[DefensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensivePerformance.sql").mkString
        val defensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(defensivePerformanceDf, "DefensivePerformance")//XXX debugging
        val defensivePerformanceList = dataframe_to_list(defensivePerformanceDf, Encoders.product[DefensivePerformance])

        // GoalkeeperPerformance Measures
        val goalkeeperPerformanceTable = TableQuery[GoalkeeperPerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperPerformance.sql").mkString
        val goalkeeperPerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(goalkeeperPerformanceDf, "GoalkeeperPerformance")//XXX debugging
        val goalkeeperPerformanceList = dataframe_to_list(goalkeeperPerformanceDf, Encoders.product[GoalkeeperPerformance])

        // PlaymakingPerformance Measures
        val playmakingPerformanceTable = TableQuery[PlaymakingPerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingPerformance.sql").mkString
        val playmakingPerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(playmakingPerformanceDf, "PlaymakingPerformance")//XXX debugging
        val playmakingPerformanceList = dataframe_to_list(playmakingPerformanceDf, Encoders.product[PlaymakingPerformance])

        System.out.println(">>> Fact measures tables loaded.")

        val op = DBIO.seq(
            //birthTable.schema.dropIfExists,
            //birthTable.schema.create,
            //birthTable ++= birthList,

            //organizationTable.schema.dropIfExists,
            //organizationTable.schema.create,
            //organizationTable ++= organizationList,

            // offensivePerformanceTable.schema.dropIfExists,
            //offensivePerformanceTable.schema.create,
            //offensivePerformanceTable ++= offensivePerformanceList,

            // DefensivePerformanceTable.schema.dropIfExists,
            //defensivePerformanceTable.schema.create,
            //defensivePerformanceTable ++= defensivePerformanceList

            // GoalkeeperPerformanceTable.schema.dropIfExists,
            //goalkeeperPerformanceTable.schema.create,
            //goalkeeperPerformanceTable ++= goalkeeperPerformanceList

            // PlaymakingPerformanceTable.schema.dropIfExists,
            //playmakingPerformanceTable.schema.create,
            //playmakingPerformanceTable ++= playmakingPerformanceList
        )

        val future = db.run(op)
        try {
            Await.result(future, Duration.Inf)
        } finally db.close
    }

    def integrate_to_NR(sparkSession: SparkSession, entityName: String): Unit = {
        val sqlString: String = scala.io.Source.fromFile(SQL_PATH_BDM + entityName + ".sql").mkString
        val dataframe = sparkSession.sql(sqlString)

        import sparkSession.implicits._
        val nestedDataframe = dataframe.map(r => {
            PlayerNR(
                PersonalData(r.getString(0)),
                FootballData(r.getString(1), r.getString(2)))
        })

        //val nestedDataframe = dataframe.map(r => {
        //    PlayerAbilityNR(
        //        r.getLong(0),
        //        r.getString(1),
        //        r.getInt(2),
        //        MentalAbilityNR(r.getInt(3),r.getInt(4),r.getInt(5),r.getInt(6)),
        //        PhysicalAbilityNR(r.getInt(7)),
        //        TechnicalAbilityNR(r.getInt(8),r.getInt(9),r.getInt(10),r.getInt(11),r.getInt(12),r.getInt(13),r.getInt(14)),
        //        GoalkeeperAbilityNR(r.getInt(15),r.getInt(16),r.getInt(17),r.getInt(18))
        //    )
        //})

        nestedDataframe
            .write
            .mode("overwrite")
            .json(s"${OUTPUT_PATH}$entityName")

        System.out.println(">>> NR integration FINISHED")
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

    //private def player_ability_mapper(r: Row): PlayerAbilityNR = {
    //    PlayerAbilityNR(
    //        r.getLong(0),
    //        r.getString(1),
    //        r.getInt(2),
    //        MentalAbilityNR(r.getInt(3),r.getInt(4),r.getInt(5),r.getInt(6)),
    //        PhysicalAbilityNR(r.getInt(7)),
    //        TechnicalAbilityNR(r.getInt(8),r.getInt(9),r.getInt(10),r.getInt(11),r.getInt(12),r.getInt(13),r.getInt(14)),
    //        GoalkeeperAbilityNR(r.getInt(15),r.getInt(16),r.getInt(17),r.getInt(18))
    //    )
    //}

    private def player_defensive_ability_mapper(r: Row): PlayerDefensiveAbilityNR = {
        PlayerDefensiveAbilityNR(
            r.getLong(0),
            r.getString(1),
            r.getInt(2),
            MentalAbilityDef(r.getInt(3)),
            TechnicalAbilityDef(r.getInt(4),r.getInt(5),r.getInt(6))
        )
    }

    private def player_goalkeeper_ability_mapper(r: Row): PlayerGoalkeeperAbilityNR = {
        PlayerGoalkeeperAbilityNR(
            r.getLong(0),
            r.getString(1),
            r.getInt(2),
            GoalkeeperAbilityGk(r.getInt(3),r.getInt(4),r.getInt(5),r.getInt(6))
        )
    }

    private def player_playmaking_ability_mapper(r: Row): PlayerPlaymakingAbilityNR = {
        PlayerPlaymakingAbilityNR(
            r.getLong(0),
            r.getString(1),
            r.getInt(2),
            MentalAbilityPm(r.getInt(3),r.getInt(4)),
            TechnicalAbilityPm(r.getInt(5),r.getInt(6))
        )
    }

}