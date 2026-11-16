import java.util.List;

void main() {
    QueryInput input = new QueryInput();
    QueryToAPI api = new QueryToAPI();
    ParseResult parser = new ParseResult();

    String query = input.askQuery();
    String apiJson = api.search(query);
    List<SearchResult> results = parser.parse(apiJson);
    if (results.isEmpty()) {
        System.out.println("Ничего не найдено");
    }
    else {
        System.out.println(results.size());
        System.out.println(results.get(0).getTitle());
    }
}