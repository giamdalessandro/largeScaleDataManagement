package it.sapienza.lsdm.logic

import org.apache.spark.sql.{SparkSession, DataFrame, Encoder}
import it.sapienza.lsdm.App.INPUT_PATH

object Main {

    def load_data(sparkSession: SparkSession): Unit = {
        val fbrefGcaDf          = read_csv_to_df(sparkSession, INPUT_PATH + "fbref-gca-extraction.csv")
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
        fbrefInfoDf         .createOrReplaceTempView("FbrefInfo")
        fbrefKeeperDf       .createOrReplaceTempView("FbrefKeeper")
        fbrefMiscDf         .createOrReplaceTempView("FbrefMisc")
        fbrefPassingDf      .createOrReplaceTempView("FbrefPassing")
        fbrefPlayingTimeDf  .createOrReplaceTempView("FbrefPlayingTime")
        fbrefPossessionDf   .createOrReplaceTempView("FbrefPossession")
        fbrefShootingDf     .createOrReplaceTempView("FbrefShooting")
        fbrefStandardDf     .createOrReplaceTempView("FbrefStamdard")
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
      * Converts a given dataframe to a list containing the same records
      *
      * @param dataframe
      * @param encoder
      * @return
      */
    def dataframe_to_list[T](dataframe: DataFrame, encoder: Encoder[T]): List[T] = {        
        return dataframe.as(encoder).collect.toList
    }
  
}
