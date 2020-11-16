package week4;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyNames {

    public void getNumberOfNames(String filePath){
        FileResource fr = new FileResource(filePath);
        int boyTotal = 0;
        int girlTotal = 0;
        CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord rec : parser){
            if (rec.get(1).equals("M")){
                boyTotal += 1;

            } else {
                girlTotal += 1;
            }
        }
        System.out.println("File path "+ filePath);
        System.out.println("Boy's names where: "+ boyTotal+" Girls names where: "+ girlTotal);
    }

    // Method to get rank for specific year
    public int getRank(String filePath, String name, String gender) {
        int rankCounter = 1;
        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser(false);

        for (CSVRecord rec : parser) {
            if (rec.get(1).equals(gender)) {
                if (rec.get(0).equals(name)) {
                    return rankCounter;
                } else {
                    rankCounter += 1;
                }
            }
        }

        return -1;
    }

    // Method to get name on specific rank
    public String getName(String filePath, int rank, String gender){
        String babyName;
        int nameRank;
        FileResource fr = new FileResource(filePath);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            babyName = rec.get(0);
            nameRank = getRank(filePath,babyName,gender);
            //System.out.println("Baby name is: "+babyName+" and rank of that name: "+nameRank);
            if(rank == nameRank){
                return babyName;
            }
        }
        return "NO NAME";
    }

    // Get Highest rank of certan name
    public void getNameHighestRank(String name, String gender){
        int rankGenevie = 999999;
        int currentRankGenevie;
        String fileName = "";
        DirectoryResource kaust = new DirectoryResource();
        for (File f : kaust.selectedFiles()) {
            //System.out.println("Looking file: " + f.getName());
            currentRankGenevie = getRank(f.getPath(),name,gender);
            if(currentRankGenevie < rankGenevie && currentRankGenevie != -1){
                rankGenevie = currentRankGenevie;
                fileName = f.getName();
            }
        }
        System.out.println("Highest rank for name "+name+" was in file "+fileName+" of value: "+rankGenevie);
    }

    //Get average rank of certan anme
    // Get Highest rank of certan name
    public void getAverageRank(String name, String gender){
        double counter = 0;
        double sumOfRanks = 0;
        double currentRank;
        double average;
        DirectoryResource kaust = new DirectoryResource();
        for (File f : kaust.selectedFiles()) {
            //System.out.println("Looking file: " + f.getName());
            currentRank = getRank(f.getPath(),name,gender);
            if(currentRank != -1){
                counter += 1;
                sumOfRanks = sumOfRanks +currentRank;
            }
        }
        average = sumOfRanks / counter;
        System.out.println("Average rank for name "+name+" is value: "+average);
    }

    public void resourceHandler(){
        //1. What is the number of girls' names in the file yob1900.csv?
        getNumberOfNames("resources/us_babynames_by_year/yob1900.csv");
        //2. What is the number of boys' names in the file yob1905.csv?
        getNumberOfNames("resources/us_babynames_by_year/yob1905.csv");
        //3. What is the rank of the girl’s name “Emily” in 1960?
        System.out.println("3. What is the rank of the girl’s name “Isabella” in 2002?");
        System.out.println(getRank("resources/us_babynames_by_year/yob2002.csv","Isabella","F"));
        // 4. What is the rank of the boy’s name “Frank” in 1971?
        //System.out.println("4. What is the rank of the boy’s name “Frank” in 1971?");
        System.out.println(getRank("resources/us_babynames_by_year/yob1985.csv","Kaido","M"));
        //5.What is the girl’s name of rank 350 in 1980?
        System.out.println("5.What is the girl’s name of rank 350 in 1980?");
        //System.out.println(getName("resources/us_babynames_by_year/yob1980.csv",350,"F"));
        //6. What is the boy’s name of rank 450 in 1982?
        System.out.println("6. What is the boy’s name of rank 450 in 1982?");
        //System.out.println(getName("resources/us_babynames_by_year/yob1982.csv",450,"M"));
        //7.Suppose Susan was born in 1972. Based on her name's rank in 1972, what would her name be if she were born in 2014 (that is, what name in 2014 had the same rank that "Susan" had in 1972)?
        //System.out.println("7. Susan name in 2014");
        //System.out.println(getRank("resources/us_babynames_by_year/yob1972.csv","Susan","F"));
        //System.out.println(getName("resources/us_babynames_by_year/yob2014.csv",24,"F"));
        //8.Suppose Owen was born in 1974. Based on his name's rank in 1974, what would his name be if he were born in 2014 (that is, what name in 2014 had the same rank that "Owen" had in 1974)?
        System.out.println("8. Kaido name in 2014");
        System.out.println(getRank("resources/us_babynames_by_year/yob1974.csv","Kaido","M"));
        //System.out.println(getName("resources/us_babynames_by_year/yob2014.csv",430,"M"));
        //9.In which year from 1880 to 2014 does the girl’s name "Genevieve" have the highest rank (over all the data files)?
        getNameHighestRank("Isabella","F");
        //10.In which year from 1880 to 2014 does the boy’s name "Mich" have the highest rank (over all the data files)?
        getNameHighestRank("Kaido","M");
        //11. What is the average rank of the girl’s name "Susan" over all the data files?
        System.out.println("11. Average rank of Isabella");
        getAverageRank("Isabella","F");
        //12. What is the average rank of the boy's name "Robert" over all the data files?
        System.out.println("12. Average rank of Kaido");
        getAverageRank("Kaido","M");

        //String filePath = "resources/us_babynames_test/yob2012short.csv";
        //System.out.println(getRank(filePath,"Fred","F"));
        //System.out.println(getName(filePath,3,"F"));

    }

    public static void main(String[] args) {
        BabyNames bn = new BabyNames();
        bn.resourceHandler();
    }
}
