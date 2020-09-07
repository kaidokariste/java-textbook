//Spark 3.0.0 and Scala 2.12.10
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class sparkDemo {
    public static void main(String[] args){
        String decJSON = "C:\\Users\\kaido.kariste\\Documents\\GitProjects\\java-textbook\\SPARK\\spark-mongo-connector\\maksud.json"; // Should be some file on your system

        SparkSession ss = SparkSession
                .builder()
                .master("local[1]")
                .appName("Java Spark SQL basic example")
                .getOrCreate();

        Dataset<Row> df = ss.read()
                .option("multiline","true") //this option is necessary, if the json file is regular not one line document
                .json(decJSON);

        df.printSchema();

        // Creates a temporary view using the DataFrame
        df.createOrReplaceTempView("maksud");

        // SQL statements can be run by using the sql methods provided by spark
        Dataset<Row> namesDF =
                ss.sql("SELECT address.city, otherFees[0].internet, paymentDetails.overallElectricity[1].day FROM maksud");
        namesDF.show();

    }
}