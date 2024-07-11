package hexlet.code.games;

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
        int hiddenStep = random.nextInt(lengthProgression);
        int firstNumber = random.nextInt(TO_RANDOM_NUMBER - FROM_RANDOM_NUMBER) + FROM_RANDOM_NUMBER;
        int stepProgression = random.nextInt(MAX_STEP_PROGRESSION) + 1;
        int hiddenNum = 0;
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < lengthProgression; ++i) {
            if (i == hiddenStep) {
                question.append("..");
                hiddenNum = firstNumber + i * stepProgression;
            } else {
                question.append(firstNumber + i * stepProgression);
            }
            if (i < lengthProgression - 1) {
                question.append(" ");
            }
        }

        return new String[] {question.toString(), String.valueOf(hiddenNum)};
    }
}