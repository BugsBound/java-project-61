package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Please enter the game number and press Enter.\n" +
                    "1 - Greet\n" +
                    "2 - Even\n" +
                    "3 - Calc\n" +
                    "0 - Exit\n" +
                    "Your choice: ");
            int selectedGame = Integer.parseInt(sc.nextLine());

            if (selectedGame == 0) {
                sc.close();
                return;
            }

            System.out.println("Welcome to the Brain Games!");

            System.out.print("May I have your name? ");
            String name = sc.nextLine();
            Cli.helloUser(name);

            if (Engine.start(selectedGame)) {
                System.out.println("Congratulations, " + name + "!");
            } else {
                System.out.println("Let's try again, " + name + "!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Only digits!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
