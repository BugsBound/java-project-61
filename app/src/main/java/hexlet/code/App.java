package hexlet.code;

public class App {
    public static void main(String[] args) {
        try {
            Engine.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
