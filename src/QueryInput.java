import java.util.Scanner;

public class QueryInput {
    Scanner scanner = new Scanner(System.in);

    public String askQuery() {
        System.out.print("Введите запрос: ");
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

    private int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Это не число, попробуйте ещё раз. ");
            }
        }
    }

    public int readChoice(int maxValue) {
        int i = 0;
        while ((i < 1) || (i > maxValue)) {
            i = readInt();
            if ((i < 1) || (i > maxValue)) {
                System.out.println("Число должно быть в диапазоне от 1 до " + maxValue);
            }
        }
        return i-1;
    }
}
