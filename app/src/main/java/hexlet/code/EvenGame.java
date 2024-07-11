package hexlet.code;

import java.util.Random;

public class EvenGame implements Game {
    private final int EVEN_DIVISOR = 2;
    private final int TO_RANDOM_NUMBER = 101;
    private final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private String rightAnswer;

    EvenGame() {
        System.out.println(this.RULES);
    }

    public String getRules() {
        return this.RULES;
    }

    public boolean isRightAnswer(String userAnswer) {
        return userAnswer.equals(rightAnswer);
    }

    public String getQuestion() {
        Random random = new Random();
        int randomNumber = random.nextInt(TO_RANDOM_NUMBER);
        this.rightAnswer = randomNumber % EVEN_DIVISOR == 0 ? "yes" : "no";

        return String.valueOf(randomNumber);
    }



}
