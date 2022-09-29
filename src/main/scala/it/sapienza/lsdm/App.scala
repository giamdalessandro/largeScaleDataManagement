package it.sapienza.lsdm

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

import slick.jdbc.PostgresProfile.api._

object App {
    final val INPUT_PATH = "src/main/scala/it/sapienza/lsdm/input/"
    final val SQL_PATH = "src/main/scala/it/sapienza/lsdm/sparksql/"
    final val OUTPUT_PATH = "src/main/scala/it/sapienza/lsdm/output/"

    val sparkSession = SparkSession
                    .builder
                    .appName("Simple Application")
                    .config("spark.master", "local")
                    .getOrCreate()

    /**
     * Coordinates the entire application workflow
     */
    def main(args: Array[String]): Unit = {
        logic.Main.load_data(sparkSession)
        
        logic.bdm.Integration.DFM_to_DW(sparkSession)

        //logic.bdm.Integration.integrate_to_NR(sparkSession, "PlayerAbilityNR")

        // add a table to DB
        //val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"Player.sql").mkString
        //val tableDf = sparkSession.sql(sqlString)
        //model.Main.init_and_populate(tableDf)

        //model.Main.load_and_insert(sparkSession, "fbref-keeper-extraction.csv", "FbrefKeep", "GoalkeeperStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-playing_time-extraction.csv", "FbrefPTime", "PresenceStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-defense-extraction.csv", "FbrefDef", "DefenseStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-shooting-extraction.csv", "FbrefSht", "GoalStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-passing-extraction.csv", "FbrefPass", "PassingStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-possession-extraction.csv", "FbrefPoss", "PlaymakingStats.sql")
        
        System.out.println(">>> FINISHED")
    }
}
