package week3;

import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            System.out.print(record.get("Name")+ " ");
            System.out.println(record.get("Favorite Food"));
        }
    }

    public static void main(String[] args){
        FirstCSVExample csvparse = new FirstCSVExample();
        csvparse.readFood();
    }
}
