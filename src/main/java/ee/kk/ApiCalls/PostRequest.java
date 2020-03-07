package ee.kk.ApiCalls;

import java.io.IOException;
import java.net.URI;
import org.json.simple.JSONObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class PostRequest {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void main(String[] args) throws IOException, InterruptedException {
        PostRequest obj = new PostRequest();
        obj.sendPOST();

    }

    private void sendPOST() throws IOException, InterruptedException {

        // json formatted data
        String jsonText;

        //Creating json body to post
        Map<String, String> map = new HashMap<>();
        map.put("name", "Kaido");
        map.put("pasw", "myPassword");
        JSONObject jo = new JSONObject(map);
        jsonText = jo.toString();

        System.out.println(jsonText);


        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonText))
                .uri(URI.create("https://householdcosts.herokuapp.com/api/v1/authenticate"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }

}
