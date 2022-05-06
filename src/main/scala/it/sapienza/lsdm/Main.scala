package it.sapienza.lsdm

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

object Main {
    private final val INPUT_PATH = "src/main/scala/it/sapienza/lsdm/input/"
    private final val SQL_PATH = "src/main/scala/it/sapienza/lsdm/sparksql/"

    val sparkSession = SparkSession
                    .builder
                    .appName("Simple Application")
                    .config("spark.master", "local")
                    .getOrCreate()

    def main(args: Array[String]): Unit = {
        /**
         * Load source datasets
         */
        val fm20Df = read_csv_to_df(sparkSession, "fm20-extraction.csv")
        val fbrefInfoDf = read_csv_to_df(sparkSession, "fbref-info-extraction.csv")

        fm20Df.createOrReplaceTempView("Fm20")
        fbrefInfoDf.createTempView("FbrefInfo")

        val sqlString: String = scala.io.Source.fromFile(SQL_PATH+"assemble.sql").mkString
        sparkSession.sql(sqlString).show()
    }

    def read_csv_to_df(sparkSession: SparkSession, filename: String): DataFrame = {
        sparkSession.read
            .option("header", "true")
            .csv(INPUT_PATH+filename)
            .toDF()
    }
}
