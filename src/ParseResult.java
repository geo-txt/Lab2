import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class ParseResult {
    private Gson gson = new Gson();

    public List<SearchResult> parse(String json) {
        try {
            JsonArray array = JsonParser.parseString(json)
                    .getAsJsonObject()
                    .getAsJsonObject("query")
                    .getAsJsonArray("search");
            SearchResult[] results = gson.fromJson(array, SearchResult[].class);
            return Arrays.asList(results);
        } catch (JsonParseException | IllegalStateException | NullPointerException e) {
            System.out.println("Не удалось разобрать ответ сервера.");
            return List.of();
        }
    }
}
