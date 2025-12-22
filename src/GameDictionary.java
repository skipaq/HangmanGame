import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameDictionary {
    public static List<String> wordsList = createDictionary();

    public static List<String> createDictionary(){
        List<String> wordsList = new ArrayList<>();
        try (InputStream dictionaryWords  = GameStarter.class.getClassLoader().getResourceAsStream("words.txt");
             Scanner scanner = new Scanner(dictionaryWords)) {
            while (scanner.hasNextLine()) {
                wordsList.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  wordsList;
    }

    public static String getRandomWord() {
        List<String> wordList = createDictionary();
        int randomWordIndex = (int)(Math.random() * wordsList.size()) + 1;
        return  wordList.get(randomWordIndex);
    }

}
