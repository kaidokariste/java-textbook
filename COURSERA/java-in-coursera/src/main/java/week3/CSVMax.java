package week3;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {

    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar, String compareParameter){
        if(largestSoFar == null){
            largestSoFar = currentRow;
        } else {
            // Check the currentRow temperature > largestSoFar
            double currentTemp = Double.parseDouble(currentRow.get(compareParameter));
            double largestTemp = Double.parseDouble(largestSoFar.get(compareParameter));
            // If so, update largest so far
            if (currentTemp>largestTemp){
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public CSVRecord getColdestOfTwo(CSVRecord currentRow, CSVRecord coldestSoFar, String compareParameter){

        if(coldestSoFar == null){
            coldestSoFar = currentRow;
        } else {
            // Check the currentRow temperature > largestSoFar
            double currentTemp = Double.parseDouble(currentRow.get(compareParameter).replace("N/A","1000"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get(compareParameter).replace("N/A","1000"));
            if (currentTemp == -9999){currentTemp = 1000;}
            if (coldestTemp == -9999){coldestTemp = 1000;}
            // If so, update largest so far
            if (currentTemp<coldestTemp){
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }

    public CSVRecord hottestHourInFile(CSVParser parser){
        //start with largest as nothing
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in csv file
        for(CSVRecord currentRow : parser){
            //If largestSoFar is nothing
            largestSoFar =  getLargestOfTwo(currentRow, largestSoFar, "TemperatureF");
        }
        // The answer is largestSoFar
        return largestSoFar;
    }

    //Get coldest hour
    public CSVRecord coldestHourInFile(CSVParser parser){
        //start with largest as nothing
        CSVRecord coldestSoFar = null;
        //For each row (currentRow) in csv file
        for(CSVRecord currentRow : parser){
            //If largestSoFar is nothing
            coldestSoFar =  getColdestOfTwo(currentRow, coldestSoFar, "TemperatureF");
        }
        // The answer is largestSoFar
        return coldestSoFar;
    }

    //GET lowest humid hour in file

    public CSVRecord leastHumidHourInFile(CSVParser parser){
        //start with largest as nothing
        CSVRecord leastHumidSoFar = null;
        //For each row (currentRow) in csv file
        for(CSVRecord currentRow : parser){
            //If largestSoFar is nothing
            leastHumidSoFar =  getColdestOfTwo(currentRow, leastHumidSoFar, "Humidity");
        }
        // The answer is largestSoFar
        return leastHumidSoFar;
    }


    //Test hottest day
    public void testHottestAndColdestInDay() {
    FileResource fr = new FileResource("resources/nc_weather/2014/weather-2014-01-03.csv");
    CSVRecord largest = hottestHourInFile(fr.getCSVParser());
    CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
    System.out.println("hottest temperature was " +largest.get("TemperatureF")+ " at " + largest.get("TimeEST"));
    System.out.println("coldest temperature was " +coldest.get("TemperatureF")+ " at " + coldest.get("TimeEST"));
}

    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // Use themethod to get largest in file
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            //If largestSoFar is nothing
            largestSoFar = getLargestOfTwo(currentRow,largestSoFar, "TemperatureF");
        }
        return largestSoFar;
    }

    public void coldestInManyDays() {
        CSVRecord coldestSoFar = null;
        File coldestFile = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // Use themethod to get largest in file
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            //If largestSoFar is nothing
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            } else {
                // Check the currentRow temperature > largestSoFar
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                // If so, update largest so far
                if (currentTemp<coldestTemp){
                    coldestSoFar = currentRow;
                    coldestFile = f;
                }
            }
        }
        System.out.println("Coldest day was in file weather "+ coldestFile);
        System.out.println("Coldest on that day was weather "+ coldestSoFar.get("TemperatureF"));
    }

    // Lowest humidity
    public void lowestHumidityInManyDays() {
        CSVRecord lowestHumiditySoFar = null;
        String lowestHumidityFile = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // Use themethod to get largest in file
            CSVRecord currentRow = leastHumidHourInFile(fr.getCSVParser());
            //If largestSoFar is nothing
            if(lowestHumiditySoFar == null){
                lowestHumiditySoFar = currentRow;
            } else {
                // Check the currentRow temperature > largestSoFar
                double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
                // If so, update largest so far
                if (currentHumidity<lowestHumidity){
                    lowestHumiditySoFar = currentRow;
                    lowestHumidityFile = f.getName();
                }
            }
        }
        System.out.println("Lowest humid day was in file weather "+ lowestHumidityFile);
        System.out.println("Lowest humidity on that day was weather "+ lowestHumiditySoFar.get("Humidity") +" at " + lowestHumiditySoFar.get("DateUTC"));
    }



    public void testHottestAndColdestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " +largest.get("TemperatureF")+ " at " + largest.get("DateUTC"));
        coldestInManyDays();
        lowestHumidityInManyDays();
    }


    public static void main(String[] args){
        CSVMax maxTemperature = new CSVMax();
        //maxTemperature.testHottestAndColdestInDay();
        maxTemperature.testHottestAndColdestInManyDays();

    }

}
