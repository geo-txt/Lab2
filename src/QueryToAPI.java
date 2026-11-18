import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class QueryToAPI {
    private String searchURL = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";
    private HttpClient client = HttpClient.newHttpClient();

    private String fullURL(String str) {
        str = URLEncoder.encode(str, StandardCharsets.UTF_8);
        return (searchURL + str);
    }

    public String search(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullURL(query)))
                .header("User-Agent", "student")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Ошибка сервера: " + response.statusCode());
                return null;
            }
            return response.body();

        } catch (IOException e) {
            System.out.println("Не удалось подключиться.");
            return null;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Запрос был прерван.");
            return null;
        }
    }
}
