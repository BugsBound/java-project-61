package hexlet.code.games;

import java.util.Random;

public class EvenGame {
    private static final int EVEN_DIVISOR = 2;
    private static final int TO_RANDOM_NUMBER = 101;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static String[] roundGenerator(boolean needPrintRules) {
        if (needPrintRules) {
            System.out.println(RULES);
        }

        Random random = new Random();
        int randomNumber = random.nextInt(TO_RANDOM_NUMBER);
        String rightAnswer = randomNumber % EVEN_DIVISOR == 0 ? "yes" : "no";
        String question = String.valueOf(randomNumber);

        return new String[] {question, rightAnswer};
    }
}
