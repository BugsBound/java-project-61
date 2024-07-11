package hexlet.code;

import java.util.Random;

public class ProgressionGame {
    private static final int FROM_RANDOM_NUMBER = 10;
    private static final int TO_RANDOM_NUMBER = 40;
    private static final int MIN_LENGTH_PROGRESSION = 5;
    private static final int MAX_LENGTH_PROGRESSION = 10;
    private static final int MAX_STEP_PROGRESSION = 5;
    private static final String RULES = "What number is missing in the progression?";

    public static String[] roundGenerator(boolean needPrintRules) {
        if (needPrintRules) {
            System.out.println(RULES);
        }

        Random random = new Random();
        int lengthProgression = random.nextInt(MAX_LENGTH_PROGRESSION - MIN_LENGTH_PROGRESSION + 1)
                + MIN_LENGTH_PROGRESSION;
        int hiddenStep = random.nextInt(lengthProgression) + 1;
        int firstNumber = random.nextInt(TO_RANDOM_NUMBER - FROM_RANDOM_NUMBER) + FROM_RANDOM_NUMBER;
        int stepProgression = random.nextInt(MAX_STEP_PROGRESSION) + 1;
        int hiddenNum = 0;
        StringBuilder question = new StringBuilder();
        question.append(firstNumber);

        for (int i = 1; i < lengthProgression; ++i) {
            question.append(" ");

            if (hiddenStep - 1 == i) {
                question.append("..");
                hiddenNum = i * stepProgression + firstNumber;
                continue;
            }

            question.append(i * stepProgression + firstNumber);
        }

        return new String[] {question.toString(), String.valueOf(hiddenNum)};
    }
}
