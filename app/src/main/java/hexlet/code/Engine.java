package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;
    private static final int FIRST_ROUND = 0;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;

    public static void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        int selectedGame;

        System.out.print("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "4 - GCD\n" +
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

        for (int i = 0; i < ROUNDS; ++i) {
            String[] dataRound;
            boolean needPrintRules = i == FIRST_ROUND;

            switch (selectedGame) {
                case 1 -> {
                    return;
                }
                case 2 -> dataRound = EvenGame.roundGenerator(needPrintRules);
                case 3 -> dataRound = CalcGame.roundGenerator(needPrintRules);
                case 4 -> dataRound = NodGame.roundGenerator(needPrintRules);
                default -> throw new Exception("Wrong game number!");
            }

            System.out.println("Question: " + dataRound[QUESTION_INDEX]);
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            if (userAnswer.equals(dataRound[ANSWER_INDEX])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                        "Correct answer was '" + dataRound[ANSWER_INDEX] + "'.");
                System.out.println("Let's try again, " + name + "!");
                sc.close();
                return;
            }
        }

        sc.close();
        System.out.println("Congratulations, " + name + "!");
    }
}
