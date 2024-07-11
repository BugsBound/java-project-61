package hexlet.code;

public class Engine {
    public static boolean start(int selectedGame) throws Exception {
        switch (selectedGame) {
            case 1 -> {
                return true;
            }
            case 2 -> {
                return EvenGame.start();
            }
            case 3 -> {
                return CalcGame.start();
            }
            default -> {
                throw new Exception("Wrong game number!");
            }
        }
    }
}
