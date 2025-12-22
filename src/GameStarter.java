import java.util.Scanner;

public class GameStarter {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Начать новую игру? Да / Нет: ");
            String userInput = scan.nextLine().trim().toLowerCase();

            if (userInput.isEmpty()) {
                System.out.println("Вы ничего не ввели!");
                continue;
            }
            if(userInput.equals("да")) {
                System.out.println("Игра началась!");
                GameLogic newGame = new GameLogic();
                newGame.game();
            } else if(userInput.equals("нет")){
                System.out.println("Очень жаль. До встречи!");
                break;
            }
            else {
                System.out.println("Некорректный ввод! Введите ДА либо НЕТ!");
            }

        }
    }
}