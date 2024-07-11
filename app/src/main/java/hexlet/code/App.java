package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "0 - Exit\n" +
                "Your choice: ");

        Scanner sc = new Scanner(System.in);
        String userChoise = sc.nextLine();
        int selectedGame;

        try {
            selectedGame = Integer.parseInt(userChoise);
        } catch (Exception e) {
            System.out.println("only digits!");
            return;
        }

        if (selectedGame == 0) {
            return;
        }

        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String name = sc.nextLine();
        Cli.helloUser(name);

        try {
            if (Engine.start(selectedGame)) {
                System.out.println("Congratulations, " + name + "!");
            } else {
                System.out.println("Let's try again, " + name + "!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
