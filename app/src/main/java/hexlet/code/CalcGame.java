package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {
    public static boolean start() {
        int NEED_MULT = 0;
        int NEED_ADD = 1;
        int NEED_SUB = 2;
        int ROUNDS = 3;

        System.out.println("What is the result of the expression?");
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int fromRandomNumber = 1;
        int toRandomNumber = 10;

        for (int i = 0; i < ROUNDS; ++i) {
            int whatNeed = random.nextInt(NEED_MULT, NEED_SUB + 1);
            int leftNum = random.nextInt(fromRandomNumber, toRandomNumber);
            int rightNum = random.nextInt(fromRandomNumber, toRandomNumber);
            System.out.print("Question: ");
            String question;
            int rightAnswer;

            if (whatNeed == NEED_MULT) {
                question = leftNum + " * " + rightNum;
                rightAnswer = leftNum * rightNum;
            } else if (whatNeed == NEED_ADD) {
                question = leftNum + " + " + rightNum;
                rightAnswer = leftNum + rightNum;
            } else if (whatNeed == NEED_SUB) {
                question = leftNum + " - " + rightNum;
                rightAnswer = leftNum - rightNum;
            } else {
                System.out.println("Something Wrong!");
                return false;
            }

            System.out.print("Question: " + question + "\nYour answer: ");
            int userAnswer = 0;

            try {
                String answer = sc.nextLine();
                userAnswer = Integer.parseInt(answer);
            } catch (Exception e) {
                return false;
            }

            if (userAnswer == rightAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                        "Correct answer was '" + rightAnswer + "'.");
                return false;
            }
        }

        return true;
    }
}
