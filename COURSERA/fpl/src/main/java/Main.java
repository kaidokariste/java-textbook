import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {
    public static void main(String args[])  {

        String jsonFile = "resource/fantasy-data.json";
        try {
            FileReader file = new FileReader(jsonFile);
            JsonParser parser = new JsonParser();
            JsonObject rootObj = parser.parse(file).getAsJsonObject();
            JsonArray elements = rootObj.getAsJsonArray("elements");
            for (JsonElement pa: elements){
                JsonObject player = pa.getAsJsonObject();
                String firstName = player.get("first_name").getAsString();
                String secondName = player.get("second_name").getAsString();
                System.out.println(firstName+" "+secondName);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

}
