import java.util.List;

public interface ContentExtractor {
  //everything is public on an interface
  List<Content> extractContentList(String json);

}
