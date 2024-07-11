package hexlet.code;

public class Engine {
    public static boolean start(int selectedGame) throws Exception {
        boolean isGameWin = false;

        switch (selectedGame) {
            case 1:
                break;
            case 2:
                return EvenGame.start();
            case 3:
                return CalcGame.start();
            default:
                throw new Exception("Wrong game number!");
        }

        return isGameWin;
    }
}
