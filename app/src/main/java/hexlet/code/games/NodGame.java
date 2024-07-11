package hexlet.code.games;

import java.util.Random;

public class NodGame {
    private static final int FROM_RANDOM_NUMBER = 1;
    private static final int TO_RANDOM_NUMBER = 50;
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static String[] roundGenerator(boolean needPrintRules) {
        if (needPrintRules) {
            System.out.println(RULES);
        }

        Random random = new Random();

        int firstNumber = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);
        int secondNumber = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);

        int answerGCD = gcd(firstNumber, secondNumber);

        return new String[] {firstNumber + " " + secondNumber, String.valueOf(answerGCD)};
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
