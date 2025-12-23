import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class GameLogic {

    private char[] randomWord;
    private char[] maskWord;
    private int mistakesCounter;
    private HashSet<Character> enteredChars = new HashSet<>();

    public GameLogic() {
        this.randomWord = GameDictionary.getRandomWord().toLowerCase().toCharArray();
        this.maskWord = new char[randomWord.length];
        this.mistakesCounter = 0;
        Arrays.fill(maskWord, GameSettings.MASK_CHAR);
    }

    public void game() {
        displayMaskedCurrentWord();
        Scanner scan = new Scanner(System.in);

        while (!isWordEquals() && mistakesCounter < GameSettings.MAX_MISTAKES){
            char enteredChar = InputValidation.userInputChar(scan);
            searchForEnteredChar(enteredChar);
            enteredChars.add(enteredChar);
            displayEnteredChars();
            drawHagman(mistakesCounter);
        }
        displayGameResult();
    }

    private void displayMaskedCurrentWord(){
        System.out.println("Загаданное слово:\n" + new String(maskWord));
    }

    private boolean isWordEquals() {
        return Arrays.equals(randomWord, maskWord);
    }

    private void displayEnteredChars() {
        System.out.println("Введенные буквы: " + enteredChars);
    }

    private void displayGameResult() {
        if (mistakesCounter >= GameSettings.MAX_MISTAKES){
            System.out.println("\nПОРАЖЕНИЕ! Загаданное слово было: " + new String(randomWord));
        } else {
            System.out.println("\nПОБЕДА! Красава!");
        }
    }

    private void searchForEnteredChar(char c){
        if(enteredChars.contains(c)){
            System.out.println("Такая буква уже вводилась! Текущее слово: " + new String(maskWord) + "\n");
            return;
        }
        boolean foundChar = false;
        for (int i = 0; i < randomWord.length; i++) {
            if (randomWord[i] == c) {
                maskWord[i] = c;
                foundChar = true;
            }
        }
        if (foundChar) {
            System.out.println("Есть такая буква! Текущее слово: " + new String(maskWord));
        } else {
            mistakesCounter++;
            System.out.println("Нет такой буквы! Ошибок: " + mistakesCounter + "/" + GameSettings.MAX_MISTAKES + ". " +
                    "Текущее слово: " + new String(maskWord));
        }
    }

    private void drawHagman(int mistakesCounter) {
        switch(mistakesCounter){
            case 1:
                System.out.println("  ____ \n" +
                                    "/     | \n" +
                                    "|     O \n" +
                                    "|        \n" +
                                    "|        \n" +
                                    "|\n" +
                                    "|\n" +
                                    "/\\");
                break;
            case 2:
                System.out.println("  ____ \n" +
                                    "/     | \n" +
                                    "|     O \n" +
                                    "|     | \n" +
                                    "|        \n" +
                                    "|\n" +
                                    "|\n" +
                                    "/\\");
                break;
            case 3:
                System.out.println("  ____ \n" +
                                    "/     | \n" +
                                    "|     O \n" +
                                    "|    /| \n" +
                                    "|       \n" +
                                    "|\n" +
                                    "|\n" +
                                    "/\\");
                break;
            case 4:
                System.out.println("  ____ \n" +
                                    "/     | \n" +
                                    "|     O \n" +
                                    "|    /|\\\n" +
                                    "|       \n" +
                                    "|\n" +
                                    "|\n" +
                                    "/\\");
                break;
            case 5:
                System.out.println("  ____ \n" +
                                    "/     | \n" +
                                    "|     O \n" +
                                    "|    /|\\\n" +
                                    "|     /  \n" +
                                    "|\n" +
                                    "|\n" +
                                    "/\\");
                break;
            case 6:
                System.out.println("  ____ \n" +
                                    "/     | \n" +
                                    "|     O \n" +
                                    "|    /|\\\n" +
                                    "|     /\\\n" +
                                    "|\n" +
                                    "|\n" +
                                    "/\\");
                break;
        }
    }
}
