package it.sapienza.lsdm.logic

import it.sapienza.lsdm.model.non_relational.PersonalData
import it.sapienza.lsdm.model.non_relational.FootballData
import it.sapienza.lsdm.model.non_relational.Player

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.Row

object Integration {
    private final val OUTPUT_PATH = "src/main/scala/it/sapienza/lsdm/output/"
    private final val SQL_PATH = "src/main/scala/it/sapienza/lsdm/sparksql/relational/"


    def integrate(sparkSession: SparkSession, entityName: String): Unit = {
        val sqlString: String = scala.io.Source.fromFile(SQL_PATH + entityName + ".sql").mkString
        val dataframe = sparkSession.sql(sqlString)

        import sparkSession.implicits._
        val nestedDataframe = dataframe.map(r => {
            Player(
                Map("name" -> r.getString(0)),
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