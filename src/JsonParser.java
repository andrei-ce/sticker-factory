import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
  
  
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> data = new ArrayList<>();

        for (String item : items) {

            Map<String, String> atributesItem = new HashMap<>();

            Matcher matcherAtributesJson = REGEX_ATRIBUTES_JSON.matcher(item);
            while (matcherAtributesJson.find()) {
                String atribute = matcherAtributesJson.group(1);
                String valor = matcherAtributesJson.group(2);
                atributesItem.put(atribute, valor);
            }

            data.add(atributesItem);
        }

        return data;
    } 


}
