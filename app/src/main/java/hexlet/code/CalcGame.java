package hexlet.code;

import java.util.Random;

public class CalcGame{
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

        String rightAnswer, question;
        switch (getRandomOperation(random)) {
            case MULTIPLICATION -> {
                rightAnswer = String.valueOf(leftNum * rightNum);
                question = leftNum + " * " + rightNum;
            }
            case ADDITION -> {
                rightAnswer = String.valueOf(leftNum + rightNum);
                question = leftNum + " + " + rightNum;
            }
            default -> {
                rightAnswer = String.valueOf(leftNum - rightNum);
                question = leftNum + " - " + rightNum;
            }
        }

        return new String[] {question, rightAnswer};
    }
}
