import java.util.List;

public class ResultOutput {

    public void printResults(List<SearchResult> results) {
        for (int i = 0; i < results.size(); i++) {
            SearchResult currentResult = results.get(i);
            System.out.println((i + 1) + ". " + currentResult.getTitle());
        }
    }
}