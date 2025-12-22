import java.util.Scanner;

public class InputValidation {
    public static final String alphabet = GameSettings.ALPHABET;

    public static char userInputChar(Scanner scanner) {
        while(true) {
            System.out.println("\nВведите букву: ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (userInput.isEmpty()) {
                System.out.println("Вы не ввели букву!");
                continue;
            }
            char c = userInput.charAt(0);
            if ((userInput.length() != 1) || alphabet.indexOf(c) == -1) {
                System.out.println("Введите только одну букву русского алфавита!");
                continue;
            }
            return c;
        }
    }
}
