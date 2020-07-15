public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Game starting...");
        Application app = new Application(new Game());
        app.Run();      
    }
}
