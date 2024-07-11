package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;

    public static void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        int selectedGame;

        System.out.print("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "0 - Exit\n" +
                "Your choice: ");
        if (sc.hasNextInt()) {
            selectedGame = sc.nextInt();
            sc.nextLine();
        } else {
            sc.nextLine();
            throw new Exception("Only digits!");
        }

        if (selectedGame == 0) {
            sc.close();
            return;
        }

        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String name = sc.nextLine();

        Cli.helloUser(name);
        Game game;

        switch (selectedGame) {
            case 1 -> {
                return;
            }
            case 2 -> game = new EvenGame();
            case 3 -> game = new CalcGame();
            default -> throw new Exception("Wrong game number!");
        }

        for (int i = 0; i < ROUNDS; ++i) {
            System.out.println("Question: " + game.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            if (!game.isRightAnswer(userAnswer)) {
                System.out.println("Let's try again, " + name + "!");
                sc.close();
                return;
            } else {
                System.out.println("Correct!");
            }
        }

        sc.close();
        System.out.println("Congratulations, " + name + "!");
    }
}
