package hexlet.code;

import java.util.Random;

public class CalcGame implements Game {
    private enum Operation {
        MULTIPLICATION,
        ADDITION,
        SUBTRACTION
    }
    private final int FROM_RANDOM_NUMBER = 1;
    private final int TO_RANDOM_NUMBER = 10;
    private final String RULES = "What is the result of the expression?";
    private String rightAnswer;
    Random random;

    CalcGame() {
        this.random = new Random();
        System.out.println(this.RULES);
    }

    public boolean isRightAnswer(String userAnswer) {
        if (!userAnswer.equals(rightAnswer)) {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                    "Correct answer was '" + rightAnswer + "'.");
            return false;
        }

        return true;
    }

    public String getQuestion() {
        int leftNum = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);
        int rightNum = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);

        return switch (this.getRandomOperation()) {
            case MULTIPLICATION -> {
                this.rightAnswer = String.valueOf(leftNum * rightNum);
                yield leftNum + " * " + rightNum;
            }
            case ADDITION -> {
                this.rightAnswer = String.valueOf(leftNum + rightNum);
                yield leftNum + " + " + rightNum;
            }
            default -> {
                this.rightAnswer = String.valueOf(leftNum - rightNum);
                yield leftNum + " - " + rightNum;
            }
        };
    }

    private Operation getRandomOperation() {
        Operation[] operations = Operation.values();
        int index = random.nextInt(operations.length);
        return operations[index];
    }
}
