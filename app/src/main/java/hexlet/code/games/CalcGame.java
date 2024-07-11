package hexlet.code.games;

import java.util.Random;

public class CalcGame {
    private enum Operation {
        MULTIPLICATION,
        ADDITION,
        SUBTRACTION
    }
    private static final int FROM_RANDOM_NUMBER = 1;
    private static final int TO_RANDOM_NUMBER = 10;
    private static final String RULES = "What is the result of the expression?";

    private static Operation getRandomOperation(Random random) {
        Operation[] operations = Operation.values();
        int index = random.nextInt(operations.length);
        return operations[index];
    }

    public static String[] roundGenerator(boolean needPrintRules) {
        if (needPrintRules) {
            System.out.println(RULES);
        }

        Random random = new Random();
        int leftNum = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);
        int rightNum = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);

        return switch (getRandomOperation(random)) {
            case MULTIPLICATION -> new String[] {leftNum + " * " + rightNum, String.valueOf(leftNum * rightNum)};
            case ADDITION -> new String[] {leftNum + " + " + rightNum, String.valueOf(leftNum + rightNum)};
            case SUBTRACTION -> new String[] {leftNum + " - " + rightNum, String.valueOf(leftNum - rightNum)};
        };
    }
}
