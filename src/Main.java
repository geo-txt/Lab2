void main() {
    QueryInput input = new QueryInput();
    QueryToAPI api = new QueryToAPI();

    String query = input.askQuery();
    api.search(query);
}