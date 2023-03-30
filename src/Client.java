import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
  
  public String fetchData(String url) {
    
    try {

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(url))
            .build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      String responseBodyString = response.body(); 
      return responseBodyString;
    
    } catch (IOException | InterruptedException ex) {
      throw new RuntimeException(ex);
    }

  }



}
