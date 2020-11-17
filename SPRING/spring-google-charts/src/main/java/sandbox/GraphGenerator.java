package sandbox;

import java.util.Map;
import java.util.TreeMap;

public class GraphGenerator {

    public void addGraphPoints(Map<Integer,Integer> dataPoints) throws InterruptedException {

        int currentSprint = 100;

        for(int i = 0; i < 10; i++){
            currentSprint = currentSprint +1;
            int abc = (int)(Math.random()*100);
            //System.out.println(currentSprint + " " + abc);
            dataPoints.put(currentSprint, abc);
            System.out.println(dataPoints);
        }


    }

    public static void main(String args[]) throws InterruptedException {
        GraphGenerator gen = new GraphGenerator();
        Map randomMap = new TreeMap<>();
        gen.addGraphPoints(randomMap);
    }
}
