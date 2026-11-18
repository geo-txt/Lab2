import java.util.List;

void main() {
    QueryInput input = new QueryInput();
    QueryToAPI api = new QueryToAPI();
    ParseResult parser = new ParseResult();
    ResultOutput output = new ResultOutput();
    OpenBrowser open = new OpenBrowser();

    while (true) {
        String query = input.askQuery();
        String apiJson = api.search(query);
        if (apiJson == null) {
            continue;
        }

        List<SearchResult> results = parser.parse(apiJson);
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            continue;
        }

        output.printResults(results);
        System.out.println("Выберите желаемую статью");
        int choice = input.readChoice(results.size());
        int selectedPageID = results.get(choice).getPageid();
        open.openByPageID(selectedPageID);
        break;
    }
}