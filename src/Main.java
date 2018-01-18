public class Main {

    public static void main(String [ ] args) {
        Environment environment = new Environment(true, "environment");
        Bot bot = new Bot("bot");
        environment.start();
        bot.start();
    }
}
