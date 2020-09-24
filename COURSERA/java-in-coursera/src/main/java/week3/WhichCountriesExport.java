package week3;

import edu.duke.*;
import org.apache.commons.csv.*;


public class WhichCountriesExport {

    public void listExporters(CSVParser parser, String exportOfInterest) {
        int total = 0;
        // for each row in csv file
        for (CSVRecord record : parser) {
            //
            String export = record.get("Exports");
            // Check if it contains ecportOfInterest
            if (export.contains(exportOfInterest)) {
             String country = record.get("Country");
             System.out.println(country);
             total = total + 1;
            }
        }
        System.out.println("<-------- TOTAL ---------->");
        System.out.println("Total "+exportOfInterest+" exporters: " +total);
    }

    public String countryInfo(CSVParser parser, String country) {
        String answer = "NOT FOUND";

        for (CSVRecord record : parser) {

            // If it contains requested country
            String export = record.get("Country");
            // Check if it contains ecportOfInterest
            if (export.contains(country)) {
                String whatExports = record.get("Exports");
                String howMuchExports = record.get("Value (dollars)");
                answer = country+": "+whatExports+": "+howMuchExports;
                //System.out.println(answer);
            }
        }
    // This method returns a string of information about the country or returns “NOT FOUND” if there is no information about the country.
        return answer;
    }

    // Countries that export these two products
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser) {

            // If it contains requested country
            String export = record.get("Exports");
            // Check if it contains ecportOfInterest
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                String whoExports = record.get("Country");
                System.out.println(whoExports);
            }
        }
    }

    //Big exporters
    public void bigExporters(CSVParser parser, String amount) {
        int amountLength = amount.length();
        System.out.println("<----- Big exporters ----->");
        for (CSVRecord record : parser) {
            String bigMoney = record.get("Value (dollars)");
            if(bigMoney.length()>amountLength){
                String whoExports = record.get("Country");
                System.out.println(whoExports+" "+bigMoney);
            }
        }

    }


    // For testing
    public void exportInfo(){
        FileResource fr = new FileResource("resources/exportdata.csv");
        CSVParser prs = fr.getCSVParser();
        // Who exports coffee
        listExporters(prs, "cocoa");
        prs = fr.getCSVParser();
        // How much does country export
        System.out.println(countryInfo(prs, "Nauru"));
        // Separator
        System.out.println("-----------Two items---------------");
        // Who exports these two items
        prs = fr.getCSVParser();
        listExportersTwoProducts(prs,"cotton","flowers");
        prs = fr.getCSVParser();
        bigExporters(prs,"$999,999,999,999");
    }


    public static void main(String[] args) {
        WhichCountriesExport wce = new WhichCountriesExport();
        wce.exportInfo();
    }
}

