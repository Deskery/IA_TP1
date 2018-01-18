import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main(String [ ] args) {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(1);
        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Environment environment = new Environment(true, "environment",out);
        Bot bot = new Bot("bot",in);
        environment.start();
        bot.start();

        while(true) {
            if (!environment.isSafe() && bot.getGoal() instanceof A2) {
                environment.setEndGame();
                bot.setEndGame();
                System.out.println("Perdu !");
                break;
            }
        }

    }
}
