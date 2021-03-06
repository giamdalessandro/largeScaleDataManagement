/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val logFile = "helloWorld.md" // Should be some file on your system
    val spark = SparkSession
                  .builder
                  .appName("Simple Application")
                  .config("spark.master", "local")
                  .getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    println(s"Hello World!\n\n")
    spark.stop()
  }
}