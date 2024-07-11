package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;
    private static final int FIRST_ROUND = 0;
    private static final int QUESTION_INDEX = 0;
    private static final int ANSWER_INDEX = 1;

    private static final int HELLO_GAME = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int NOD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;

    private static final int LENGTH_ANSWER = 2;

    public static void start() throws Exception {
        Scanner sc = new Scanner(System.in);
        int selectedGame;

        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n"
                + "Your choice: ");
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
            String[] dataRound = new String[LENGTH_ANSWER];
            boolean needPrintRules = i == FIRST_ROUND;

            switch (selectedGame) {
                case HELLO_GAME -> {
                    return;
                }
                case EVEN_GAME -> dataRound = EvenGame.roundGenerator(needPrintRules);
                case CALC_GAME -> dataRound = CalcGame.roundGenerator(needPrintRules);
                case NOD_GAME -> dataRound = NodGame.roundGenerator(needPrintRules);
                case PROGRESSION_GAME -> dataRound = ProgressionGame.roundGenerator(needPrintRules);
                case PRIME_GAME -> dataRound = PrimeGame.roundGenerator(needPrintRules);
                default -> throw new Exception("Wrong game number!");
            }

            System.out.println("Question: " + dataRound[QUESTION_INDEX]);
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            if (userAnswer.equals(dataRound[ANSWER_INDEX])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + dataRound[ANSWER_INDEX] + "'.");
                System.out.println("Let's try again, " + name + "!");
                sc.close();
                return;
            }
        }

        sc.close();
        System.out.println("Congratulations, " + name + "!");
    }
}
