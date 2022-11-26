package it.sapienza.lsdm.logic.bdm

import it.sapienza.lsdm.App.SQL_PATH
import it.sapienza.lsdm.App.{INPUT_PATH, OUTPUT_PATH}

import it.sapienza.lsdm.logic.bdm.Mapper._

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
         * GoalkeeperPerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperPerformanceFull.sql").mkString
        var goalkeeperPerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        goalkeeperPerformanceFullDf = goalkeeperPerformanceFullDf.withColumn("id", monotonically_increasing_id())
        goalkeeperPerformanceFullDf.createOrReplaceTempView("GoalkeeperPerformanceFull")
        write_df_to_csv(goalkeeperPerformanceFullDf, "GoalkeeperPerformanceFull")//XXX debugging

        /**
         * DefensivePerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensivePerformanceFull.sql").mkString
        var defensivePerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        defensivePerformanceFullDf = defensivePerformanceFullDf.withColumn("id", monotonically_increasing_id())
        defensivePerformanceFullDf.createOrReplaceTempView("DefensivePerformanceFull")
        write_df_to_csv(defensivePerformanceFullDf, "DefensivePerformanceFull")//XXX debugging

        /**
         * PlaymakingPerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingPerformanceFull.sql").mkString
        var playmakingPerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        playmakingPerformanceFullDf = playmakingPerformanceFullDf.withColumn("id", monotonically_increasing_id())
        playmakingPerformanceFullDf.createOrReplaceTempView("PlaymakingPerformanceFull")
        write_df_to_csv(playmakingPerformanceFullDf, "PlaymakingPerformanceFull")//XXX debugging

        /**
         * OffensivePerformance Full
         */
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformanceFull.sql").mkString
        var offensivePerformanceFullDf: DataFrame = sparkSession.sql(sqlString)
        offensivePerformanceFullDf = offensivePerformanceFullDf.withColumn("id", monotonically_increasing_id())
        offensivePerformanceFullDf.createOrReplaceTempView("OffensivePerformanceFull")
        write_df_to_csv(offensivePerformanceFullDf, "OffensivePerformanceFull")//XXX debugging

        /**
         * Dimensions
         */

        // GoalkeeperAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperAbility.sql").mkString
        var gkAbilityDf = sparkSession.sql(sqlString)
        gkAbilityDf = gkAbilityDf.withColumn("id", monotonically_increasing_id())
        gkAbilityDf.createOrReplaceTempView("GoalkeeperAbility")
        import sparkSession.implicits._
        val gkAbilityNds = gkAbilityDf.map(r => goalkeeper_ability_mapper(r))
        write_data_to_parquet(gkAbilityNds, "GoalkeeperAbility")

        // DefensiveAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensiveAbility.sql").mkString
        var defAbilityDf = sparkSession.sql(sqlString)
        defAbilityDf = defAbilityDf.withColumn("id", monotonically_increasing_id())
        defAbilityDf.createOrReplaceTempView("DefensiveAbility")
        import sparkSession.implicits._
        val defAbilityNds = defAbilityDf.map(r => defensive_ability_mapper(r))
        write_data_to_parquet(defAbilityNds, "DefensiveAbility")

        // PlaymakingAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingAbility.sql").mkString
        var playerPmAbDf = sparkSession.sql(sqlString)
        playerPmAbDf = playerPmAbDf.withColumn("id", monotonically_increasing_id())
        playerPmAbDf.createOrReplaceTempView("PlaymakingAbility")
        import sparkSession.implicits._
        val pmAbilityNds = playerPmAbDf.map(r => playmaking_ability_mapper(r))
        write_data_to_parquet(pmAbilityNds, "PlaymakingAbility")

        // OffensiveAbility Dimension - Non-Relational
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensiveAbility.sql").mkString
        var offensiveAbilityDf = sparkSession.sql(sqlString)
        offensiveAbilityDf = offensiveAbilityDf.withColumn("id", monotonically_increasing_id())
        offensiveAbilityDf.createOrReplaceTempView("OffensiveAbility")
        import sparkSession.implicits._
        val offensiveAbilityNds = offensiveAbilityDf.map(r => offensive_ability_mapper(r))
        write_data_to_parquet(offensiveAbilityNds, "OffensiveAbility")

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

        System.out.println(">>> Dimensions relations processing completed.")

        /**
         * Fact Measures
         */

        // GoalkeeperPerformance Measures
        val goalkeeperPerformanceTable = TableQuery[GoalkeeperPerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "GoalkeeperPerformance.sql").mkString
        val goalkeeperPerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(goalkeeperPerformanceDf, "GoalkeeperPerformance")//XXX debugging
        val goalkeeperPerformanceList = dataframe_to_list(goalkeeperPerformanceDf, Encoders.product[GoalkeeperPerformance])

        // DefensivePerformance Measures
        val defensivePerformanceTable = TableQuery[DefensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "DefensivePerformance.sql").mkString
        val defensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(defensivePerformanceDf, "DefensivePerformance")//XXX debugging
        val defensivePerformanceList = dataframe_to_list(defensivePerformanceDf, Encoders.product[DefensivePerformance])

        // PlaymakingPerformance Measures
        val playmakingPerformanceTable = TableQuery[PlaymakingPerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "PlaymakingPerformance.sql").mkString
        val playmakingPerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(playmakingPerformanceDf, "PlaymakingPerformance")//XXX debugging
        val playmakingPerformanceList = dataframe_to_list(playmakingPerformanceDf, Encoders.product[PlaymakingPerformance])

        // OffensivePerformance Measures
        val offensivePerformanceTable = TableQuery[OffensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformance.sql").mkString
        val offensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)
        write_df_to_csv(offensivePerformanceDf, "OffensivePerformance")//XXX debugging
        val offensivePerformanceList = dataframe_to_list(offensivePerformanceDf, Encoders.product[OffensivePerformance])

        System.out.println(">>> Fact measures relations processing completed.")

        /**
         * DB Operations
         */

        // Drop

        val dropOp = DBIO.seq(
            goalkeeperPerformanceTable.schema.drop,
            defensivePerformanceTable.schema.drop,
            playmakingPerformanceTable.schema.drop,
            offensivePerformanceTable.schema.drop,

            birthTable.schema.drop,
            roleTable.schema.drop,
            playerOrganizationTable.schema.drop
        )
        val dropFuture = db.run(dropOp)
        try {
            Await.result(dropFuture, Duration.Inf)

            System.out.println(">>> DB tables dropped.")
        }
        catch {
            case e: Exception => {
                db.close()
                e.printStackTrace()
                return
            }
        }

        // Create

        val createOp = DBIO.seq(
            playerOrganizationTable.schema.create,
            roleTable.schema.create,
            birthTable.schema.create,

            goalkeeperPerformanceTable.schema.create,
            defensivePerformanceTable.schema.create,
            playmakingPerformanceTable.schema.create,
            offensivePerformanceTable.schema.create
        )
        val createFuture = db.run(createOp)
        try {
            Await.result(createFuture, Duration.Inf)

            System.out.println(">>> DB tables created.")
        }
        catch {
            case e: Exception => {
                db.close()
                e.printStackTrace()
                return
            }
        }

        // Populate

        val populateOp = DBIO.seq(
            playerOrganizationTable ++= playerOrganizationList,
            roleTable ++= roleList,
            birthTable ++= birthList,

            goalkeeperPerformanceTable ++= goalkeeperPerformanceList,
            defensivePerformanceTable ++= defensivePerformanceList,
            playmakingPerformanceTable ++= playmakingPerformanceList,
            offensivePerformanceTable ++= offensivePerformanceList
        )
        val populateFuture = db.run(populateOp)
        try {
            Await.result(populateFuture, Duration.Inf)

            System.out.println(">>> DB tables populated.")
        } 
        catch {
            case e: Exception => {
                db.close()
                e.printStackTrace()
                return
            }
        }
        finally db.close
    }

    private def read_role_csv_to_df(sparkSession: SparkSession, path: String): DataFrame = {
        sparkSession.read
            .option("header", "true")
            .option("sep", ";")
            .csv(path)
            .toDF()
    }
}