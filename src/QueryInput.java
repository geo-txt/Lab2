import java.util.Scanner;

public class QueryInput {
    Scanner scanner = new Scanner(System.in);

    public String askQuery() {
        while (true) {
            String query = scanner.nextLine().strip();
            if (query.isEmpty()) {
                System.out.println("Некорректный ввод, повторите попытку");
            }
            else {
                return query;
            }
        }
    }
}
