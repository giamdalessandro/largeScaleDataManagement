package it.sapienza.lsdm

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

import slick.jdbc.PostgresProfile.api._
import it.sapienza.lsdm.model.{Player,PlayerEntity}

object App {
    private final val INPUT_PATH = "src/main/scala/it/sapienza/lsdm/input/"
    private final val SQL_PATH = "src/main/scala/it/sapienza/lsdm/sparksql/"

    val sparkSession = SparkSession
                    .builder
                    .appName("Simple Application")
                    .config("spark.master", "local")
                    .getOrCreate()

    /**
     * Load source datasets
     */
    def main(args: Array[String]): Unit = {
        val fm20Df      = model.Main.read_csv_to_df(sparkSession, "fm20-extraction.csv").dropDuplicates("name")
        val fbrefInfoDf = model.Main.read_csv_to_df(sparkSession, "fbref-info-extraction.csv")

        fm20Df.createOrReplaceTempView("Fm20")
        fbrefInfoDf.createTempView("FbrefInfo")
        
        // add a table to DB
        //val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"Player.sql").mkString
        //val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"TechnicalAbility.sql").mkString
        val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"MentalAbility.sql").mkString
        //val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"PhysicalAbility.sql").mkString
        //val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"GoalkeeperAbility.sql").mkString
        val tableDf = sparkSession.sql(sqlString)
        model.Main.init_and_populate(tableDf)

        //model.Main.load_and_insert(sparkSession, "fbref-gca-extraction.csv", "FbrefGca", "ActionStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-defense-extraction.csv", "FbrefDef", "DefenseStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-keeper-extraction.csv", "FbrefKeep", "KeeperStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-passing-extraction.csv", "FbrefPass", "PassingStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-playing_time-extraction.csv", "FbrefPTime", "PlayingTimeStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-possession-extraction.csv", "FbrefPoss", "PossessionStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-standard-extraction.csv", "FbrefStd", "StandardStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-shooting-extraction.csv", "FbrefSht", "ShootingStats.sql")
        //model.Main.load_and_insert(sparkSession, "fbref-misc-extraction.csv", "FbrefMisc", "MiscStats.sql")

    }
}
