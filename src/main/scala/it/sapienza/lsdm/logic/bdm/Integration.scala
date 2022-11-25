package it.sapienza.lsdm.logic.bdm

import it.sapienza.lsdm.App.SQL_PATH
import it.sapienza.lsdm.App.{INPUT_PATH, OUTPUT_PATH}

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

        //XXX WIP

        // /**
        //  * DefensivePerformance Full
        //  */
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensivePerformanceFull.sql").mkString
        // var defensivePerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        // defensivePerformanceFullDf = defensivePerformanceFullDf.withColumn("id", monotonically_increasing_id())
        // defensivePerformanceFullDf.createOrReplaceTempView("DefensivePerformanceFull")
        // write_df_to_csv(defensivePerformanceFullDf, "DefensivePerformanceFull")//XXX debugging

        // /**
        //  * GoalkeeperPerformance Full
        //  */
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperPerformanceFull.sql").mkString
        // var goalkeeperPerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        // goalkeeperPerformanceFullDf = goalkeeperPerformanceFullDf.withColumn("id", monotonically_increasing_id())
        // goalkeeperPerformanceFullDf.createOrReplaceTempView("GoalkeeperPerformanceFull")
        // write_df_to_csv(goalkeeperPerformanceFullDf, "GoalkeeperPerformanceFull")//XXX debugging

        // /**
        //  * PlaymakingPerformance Full
        //  */
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingPerformanceFull.sql").mkString
        // var playmakingPerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        // playmakingPerformanceFullDf = playmakingPerformanceFullDf.withColumn("id", monotonically_increasing_id())
        // playmakingPerformanceFullDf.createOrReplaceTempView("PlaymakingPerformanceFull")
        // write_df_to_csv(playmakingPerformanceFullDf, "PlaymakingPerformanceFull")//XXX debugging

        /**
         * Dimensions
         */

        // PlayerOffensiveAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerOffensiveAbilityNR.sql").mkString
        var playerOffAbDf = sparkSession.sql(sqlString)
        playerOffAbDf = playerOffAbDf.withColumn("id", monotonically_increasing_id())
        playerOffAbDf.createOrReplaceTempView("OffensiveAbility")
        import sparkSession.implicits._
        val offNestedDataset = playerOffAbDf.map(r => player_offensive_ability_mapper(r))
        write_data_to_parquet(offNestedDataset, "PlayerOffensiveAbility")

        //XXX WIP

        // // PlayerDefensiveAbility Dimension - Non-Relational
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerDefensiveAbilityNR.sql").mkString
        // val playerDefAbDf = sparkSession.sql(sqlString)
        // import sparkSession.implicits._
        // val defNestedDataset = playerDefAbDf.map(r => player_defensive_ability_mapper(r))
        // write_data_to_parquet(defNestedDataset, "PlayerDefensiveAbilityNR")

        // // PlayerGoalkeeperAbility Dimension - Non-Relational
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerGoalkeeperAbilityNR.sql").mkString
        // val playerGkAbDf = sparkSession.sql(sqlString)
        // import sparkSession.implicits._
        // val gkNestedDataset = playerGkAbDf.map(r => player_goalkeeper_ability_mapper(r))
        // write_data_to_parquet(gkNestedDataset, "PlayerGoalkeeperAbilityNR")

        // // PlayerPlaymakingAbility Dimension - Non-Relational
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerPlaymakingAbilityNR.sql").mkString
        // val playerPmAbDf = sparkSession.sql(sqlString)
        // import sparkSession.implicits._
        // val pmNestedDataset = playerPmAbDf.map(r => player_playmaking_ability_mapper(r))
        // write_data_to_parquet(pmNestedDataset, "PlayerPlaymakingAbilityNR")

        // Birth Dimension
        val birthTable = TableQuery[BirthEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "Birth.sql").mkString
        var birthDf: DataFrame = sparkSession.sql(sqlString)
        birthDf = birthDf.withColumn("id", monotonically_increasing_id())
        birthDf.createOrReplaceTempView("Birth")
        write_df_to_csv(birthDf, "Birth")//XXX debugging
        val birthList = dataframe_to_list(birthDf, Encoders.product[Birth])

        // Role Dimension
        val roleTable = TableQuery[RoleEntity]
        var roleDf: DataFrame = read_role_csv_to_df(sparkSession, INPUT_PATH + "fbref-position_distinct.csv")
        roleDf = roleDf.withColumn("id", monotonically_increasing_id())
        roleDf.createOrReplaceTempView("Role")
        write_df_to_csv(roleDf, "Role")//XXX debugging
        val roleList = dataframe_to_list(roleDf, Encoders.product[Role])

        // PlayerOrganization Dimension
        val playerOrganizationTable = TableQuery[PlayerOrganizationEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlayerOrganization.sql").mkString
        var playerOrganizationDf: DataFrame = sparkSession.sql(sqlString)
        playerOrganizationDf = playerOrganizationDf.withColumn("id", monotonically_increasing_id())
        playerOrganizationDf.createOrReplaceTempView("PlayerOrganization")
        write_df_to_csv(playerOrganizationDf, "PlayerOrganization")//XXX debugging
        val playerOrganizationList = dataframe_to_list(playerOrganizationDf, Encoders.product[PlayerOrganization])

        System.out.println(">>> Dimension relations ready to be written on db.")

        /**
         * Fact Measures
         */

        // OffensivePerformance Measures
        val offensivePerformanceTable = TableQuery[OffensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformance.sql").mkString
        val offensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(offensivePerformanceDf, "OffensivePerformance")//XXX debugging
        val offensivePerformanceList = dataframe_to_list(offensivePerformanceDf, Encoders.product[OffensivePerformance])

        //XXX WIP

        // // DefensivePerformance Measures
        // val defensivePerformanceTable = TableQuery[DefensivePerformanceEntity]
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensivePerformance.sql").mkString
        // val defensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        // write_df_to_csv(defensivePerformanceDf, "DefensivePerformance")//XXX debugging
        // val defensivePerformanceList = dataframe_to_list(defensivePerformanceDf, Encoders.product[DefensivePerformance])

        // // GoalkeeperPerformance Measures
        // val goalkeeperPerformanceTable = TableQuery[GoalkeeperPerformanceEntity]
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperPerformance.sql").mkString
        // val goalkeeperPerformanceDf: DataFrame = sparkSession.sql(sqlString)
        // write_df_to_csv(goalkeeperPerformanceDf, "GoalkeeperPerformance")//XXX debugging
        // val goalkeeperPerformanceList = dataframe_to_list(goalkeeperPerformanceDf, Encoders.product[GoalkeeperPerformance])

        // // PlaymakingPerformance Measures
        // val playmakingPerformanceTable = TableQuery[PlaymakingPerformanceEntity]
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingPerformance.sql").mkString
        // val playmakingPerformanceDf: DataFrame = sparkSession.sql(sqlString)
        // write_df_to_csv(playmakingPerformanceDf, "PlaymakingPerformance")//XXX debugging
        // val playmakingPerformanceList = dataframe_to_list(playmakingPerformanceDf, Encoders.product[PlaymakingPerformance])

        // System.out.println(">>> Fact measures relations ready to be written on db.")

        /**
         * DB Operations
         */

        // Drop

        val dropOp = DBIO.seq(
            offensivePerformanceTable.schema.drop,
            // defensivePerformanceTable.schema.drop,
            // goalkeeperPerformanceTable.schema.drop,
            // playmakingPerformanceTable.schema.drop,

            birthTable.schema.drop,
            roleTable.schema.drop,
            playerOrganizationTable.schema.drop
        )
        val dropFuture = db.run(dropOp)
        Await.result(dropFuture, Duration.Inf)

        System.out.println(">>> DB tables dropped.")

        // Create

        val createOp = DBIO.seq(
            playerOrganizationTable.schema.create,
            roleTable.schema.create,
            birthTable.schema.create,
            // defensivePerformanceTable.schema.create,
            // goalkeeperPerformanceTable.schema.create,
            // playmakingPerformanceTable.schema.create,
            offensivePerformanceTable.schema.create
        )
        val createFuture = db.run(createOp)
        Await.result(createFuture, Duration.Inf)

        System.out.println(">>> DB tables created.")

        // Populate

        val populateOp = DBIO.seq(
            playerOrganizationTable ++= playerOrganizationList,
            roleTable ++= roleList,
            birthTable ++= birthList,
            // defensivePerformanceTable ++= defensivePerformanceList,
            // goalkeeperPerformanceTable ++= goalkeeperPerformanceList,
            // playmakingPerformanceTable ++= playmakingPerformanceList,
            offensivePerformanceTable ++= offensivePerformanceList
        )
        val populateFuture = db.run(populateOp)
        try {
            Await.result(populateFuture, Duration.Inf)

            System.out.println(">>> DB tables populated.")
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
        //    PlayerDefensiveAbilityNR(
        //    r.getLong(0),
        //    r.getString(1),
        //    r.getInt(2),
        //    MentalAbilityDef(r.getInt(3)),
        //    TechnicalAbilityDef(r.getInt(4),r.getInt(5),r.getInt(6))
        //)
        //})

        nestedDataframe
            .write
            .mode("overwrite")
            .parquet(s"${OUTPUT_PATH}$entityName")
        //nestedDataframe
        //    .write
        //    .mode("overwrite")
        //    .json(s"${OUTPUT_PATH}$entityName")

        System.out.println(">>> NR integration FINISHED")
    }

    private def player_offensive_ability_mapper(r: Row): PlayerOffensiveAbilityNR = {
        val id = r.getAs[Long]("id")
        val ca = r.getAs[Int]("ca")
        val cnt = r.getAs[Int]("cnt")
        val str = r.getAs[Int]("str")
        val tec = r.getAs[Int]("tec")
        val fin = r.getAs[Int]("fin")

        PlayerOffensiveAbilityNR(
            id,
            ca,
            MentalAbility(cnt),
            PhysicalAbility(str),
            TechnicalAbility(tec, fin)
        )
    }

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
            MentalAbilityPm(r.getInt(3),r.getInt(4),r.getInt(8)),
            TechnicalAbilityPm(r.getInt(5),r.getInt(6)),
            PhysicalAbilityPm(r.getInt(7))
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

    private def read_role_csv_to_df(sparkSession: SparkSession, path: String): DataFrame = {
        sparkSession.read
            .option("header", "true")
            .option("sep", ";")
            .csv(path)
            .toDF()
    }
}