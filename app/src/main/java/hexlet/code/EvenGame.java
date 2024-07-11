package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static boolean start() {
        int EVEN_DIVISOR = 2;
        int ROUNDS = 3;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int fromRandomNumber = 1;
        int toRandomNumber = 100;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < ROUNDS; ++i) {
            int randomNumber = random.nextInt(fromRandomNumber, toRandomNumber);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            String rightAnswer = randomNumber % EVEN_DIVISOR == 0 ? "yes" : "no";

            if (userAnswer.equals(rightAnswer)) {
                System.out.println("Correct!");
            } else {
                return false;
            }
        }

        return true;
    }
}
