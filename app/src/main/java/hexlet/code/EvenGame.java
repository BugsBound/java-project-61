package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final int EVEN_DIVISOR = 2;
    private static final int ROUNDS = 3;
    private static final int FROM_RANDOM_NUMBER = 1;
    private static final int TO_RANDOM_NUMBER = 100;

    public static boolean start() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = FROM_RANDOM_NUMBER + random.nextInt(TO_RANDOM_NUMBER);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            String rightAnswer = randomNumber % EVEN_DIVISOR == 0 ? "yes" : "no";

            if (userAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                sc.close();
                return false;
            }
        }

        sc.close();
        return true;
    }
}
