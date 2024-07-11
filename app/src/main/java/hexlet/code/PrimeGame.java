package hexlet.code;

import java.util.Random;

public class PrimeGame {
    private static final int MIN_RANDOM_NUMBER = 10;
    private static final int MAX_RANDOM_NUMBER = 101;
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String[] roundGenerator(boolean needPrintRules) {
        if (needPrintRules) {
            System.out.println(RULES);
        }

        Random random = new Random();
        int question = random.nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1) + MIN_RANDOM_NUMBER;
        String answer = isPrime(question) ? "yes" : "no";

        return new String[] {String.valueOf(question), answer};
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
