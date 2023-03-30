import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorNASA implements ContentExtractor{
  
  public List<Content> extractContentList(String json){
    
    //parse only what I want
    JsonParser jsonParser = new JsonParser();
    List<Map<String, String>> attributeList = jsonParser.parse(json);

    List<Content> contentList = new ArrayList<>();
    
    //populate contentList with the json attributes
    for (Map<String, String> attribute : attributeList) {
      String title = attribute.get("title");
      String imageURL = attribute.get("url");
      
      var content = new Content(title, imageURL);
      contentList.add(content);
    }

    return contentList;
  }
}
