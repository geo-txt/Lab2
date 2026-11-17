import java.util.List;

void main() {
    QueryInput input = new QueryInput();
    QueryToAPI api = new QueryToAPI();
    ParseResult parser = new ParseResult();
    ResultOutput output = new ResultOutput();
    OpenBrowser open = new OpenBrowser();

    String query = input.askQuery();
    String apiJson = api.search(query);
    List<SearchResult> results = parser.parse(apiJson);
    if (results.isEmpty()) {
        System.out.println("Ничего не найдено");
    }
    else {
        output.printResults(results);
        System.out.println("Выберите желаемую статью");
        int choice = input.readChoice(results.size());
        int selectedPageID = results.get(choice).getPageid();
        open.openByPageID(selectedPageID);
    }
}