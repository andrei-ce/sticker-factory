import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {

    public static void main(String[] args) throws Exception {
        String url = "https://rickandmortyapi.com/api/character";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBodyString = response.body();
        
        JSONParser jsonParser = new JSONParser();
        Object responseBodyObject = jsonParser.parse(responseBodyString);
        
        System.out.println("=========================");
        System.out.println("=========================");
        System.out.println(responseBodyObject.getClass().toString());
        System.out.println("=========================");
        System.out.println("=========================");

        // Map<String, Object> MyArray = responseBodyObject
        

        System.out.println(responseBodyObject);
    }
}