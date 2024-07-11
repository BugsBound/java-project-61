package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {
    private static final int NEED_MULT = 0;
    private static final int NEED_ADD = 1;
    private static final int NEED_SUB = 2;
    private static final int ROUNDS = 3;
    private static final int FROM_RANDOM_NUMBER = 1;
    private static final int TO_RANDOM_NUMBER = 10;

    public static boolean start() {
        System.out.println("What is the result of the expression?");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < ROUNDS; i++) {
            int whatNeed = random.nextInt(NEED_SUB + 1);
            int leftNum = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);
            int rightNum = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);

            String question;
            int rightAnswer;

            switch (whatNeed) {
                case NEED_MULT -> {
                    question = leftNum + " * " + rightNum;
                    rightAnswer = leftNum * rightNum;
                }
                case NEED_ADD -> {
                    question = leftNum + " + " + rightNum;
                    rightAnswer = leftNum + rightNum;
                }
                case NEED_SUB -> {
                    question = leftNum + " - " + rightNum;
                    rightAnswer = leftNum - rightNum;
                }
                default -> {
                    System.out.println("Something Wrong!");
                    sc.close();
                    return false;
                }
            }

            System.out.print("Question: " + question + "\nYour answer: ");
            try {
                int userAnswer = Integer.parseInt(sc.nextLine());

                if (userAnswer == rightAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                            "Correct answer was '" + rightAnswer + "'.");
                    sc.close();
                    return false;
                }
            } catch (NumberFormatException e) {
                sc.close();
                return false;
            }
        }

        sc.close();
        return true;
    }
}
