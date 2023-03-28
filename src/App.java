import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
public class App {

    public static void main(String[] args) throws Exception {

      //GET top movies from= imdb
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBodyString = response.body();
        
      //Parse (Title, image, rating)
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> movieList = jsonParser.parse(responseBodyString);
        
      //Manipulate & print
        //System.out.println(movieList.get(0));

        for (Map<String,String> movie : movieList) {
          System.out.println("============================================");
          System.out.println(movie.get("title"));
          System.out.println(movie.get("image"));
          
          double roundedRating = Double.parseDouble(movie.get("imDbRating"));
          String starUnicode = "\uD83C\uDF1F";
          for (int i = 1; i < roundedRating; i++) {
            System.out.print(starUnicode);
          }
          System.out.println("["+roundedRating+"]");
          System.out.println("============================================");
        }
    }
}