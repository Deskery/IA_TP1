public class Game {
    private Environment environment;
    private Bot bot;

    public Game() {
        this.environment = new Environment("EnvironmentThread");
        this.bot = new Bot("BotThread", environment);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public void startGame() {
        this.environment.start();
        this.bot.start();

        while (true) {
            if (!environment.isSafe() && bot.getGoal() != Goal.wait) {
                environment.setEndGame();
                bot.setEndGame();
                System.out.println("T'es mort ! Fallait pas sortir dans de telles conditions !");
                break;
            }
        }
    }
}
