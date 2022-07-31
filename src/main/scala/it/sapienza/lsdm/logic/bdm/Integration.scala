package it.sapienza.lsdm.logic.bdm

import it.sapienza.lsdm.App.SQL_PATH
import it.sapienza.lsdm.App.OUTPUT_PATH

import it.sapienza.lsdm.model.bdm.PersonalData
import it.sapienza.lsdm.model.bdm.FootballData
import it.sapienza.lsdm.model.bdm.PlayerNR

import org.apache.spark.sql.{SparkSession, DataFrame, Encoders}
import slick.jdbc.H2Profile.api._
import it.sapienza.lsdm.model.bdm._

import it.sapienza.lsdm.logic.Main._

object Integration {
    private final val SQL_PATH_BDM = SQL_PATH + "bdm/"

    def DFM_to_ROLAP(sparkSession: SparkSession): Unit = {
        var sqlString: String = null

        /**
         * OffensivePerformance Fact
        */

        // OffensivePerformance Measures
        val offensivePerformanceTable = TableQuery[OffensivePerformanceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensivePerformance.sql").mkString
        val offensivePerformanceDf: DataFrame = sparkSession.sql(sqlString)

        // OffensiveAbility Dimension
        val offensiveAbilityTable = TableQuery[OffensiveAbilityEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "OffensiveAbility.sql").mkString
        val offensiveAbilityDf: DataFrame = sparkSession.sql(sqlString)
        val offensiveAbilityList = dataframe_to_list(offensiveAbilityDf, Encoders.product[OffensiveAbility])

        //XXX
        // Organization Dimension
        // sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "Organization.sql").mkString
        // val organizationDf: DataFrame = sparkSession.sql(sqlString)

        // Presence Dimension
        val presenceTable = TableQuery[PresenceEntity]
        sqlString = scala.io.Source.fromFile(SQL_PATH_BDM + "Presence.sql").mkString
        val presenceDf: DataFrame = sparkSession.sql(sqlString)
        val presenceList = dataframe_to_list(presenceDf, Encoders.product[Presence])

        //TODO WIP
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

}