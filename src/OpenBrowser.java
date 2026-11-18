import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class OpenBrowser {
    private String searchURL = "https://ru.wikipedia.org/w/index.php?curid=";

    public void openByPageID(int id) {
        String url = searchURL + id;

        try {
            Desktop.getDesktop().browse(URI.create(url));
        } catch (IOException e) {
            System.out.println("Не удалось открыть браузер.");
        }
    }
}
