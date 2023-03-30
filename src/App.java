import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

      //GET top movies from= imdb
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        ContentExtractor extractor = new ContentExtractorIMDB();
        
        // String url = "https://api.nasa.gov/planetary/apod?api_key=4oJl8Uksfr9g5NQt5iZ7ODa61KqoUxgG6PZtXSpF&start_date=2023-03-27&end_date=2023-03-29";
        // ContentExtractor extractor = new ContentExtractorNASA();
        
        var client = new Client();
        String jsonAsString = client.fetchData(url);
        
        //Parse (Title, image, rating)
        
        List<Content> contentList = extractor.extractContentList(jsonAsString);
        
      //Print & create movie images
        //initialize instance of Class outside loop
        StickerFactory stickerFactory = new StickerFactory();

        for (int i = 0; i < 3; i++) {
          Content contentItem = contentList.get(i);
          //generate images
          String image = contentItem.imageURL();
          String title = contentItem.title();
          
          InputStream inputStream = new URL(image).openStream();
          stickerFactory.create(inputStream, title + ".png");

          //console print logic
          System.out.println("============================================");
          System.out.println(title);
          
          // ---This was for the IMDB API only---
          // double roundedRating = Double.parseDouble(contentItem.get("imDbRating"));
          // String starUnicode = "\uD83C\uDF1F";
          // for (int j = 1; i < roundedRating; i++) {
          //   System.out.print(starUnicode);
          // }
          // System.out.println("["+roundedRating+"]");
          // ---This was for the IMDB API only---
          System.out.println("============================================");
        }
    }
}