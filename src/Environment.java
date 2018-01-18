import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

public class Environment extends Thread {
    private String threadName;
    private PipedOutputStream out;
    private boolean safe;
    private boolean endGame;

    public Environment(boolean safe, String threadName, PipedOutputStream out) {
        this.safe = safe;
        this.endGame = false;
        this.threadName = threadName;
        this.out = out;
    }

    public void setEndGame() {
        this.endGame = true;
    }

    public boolean isSafe() {
        return safe;
    }

    private void setRandomState() {
        double randomVar = Math.random();
        this.safe = randomVar >= 0.2;

        try {
            if (safe) {
                out.write(0);
            }
            else {
                out.write(1);
            }
        } catch (IOException e) { e.printStackTrace();}
    }

    @Override
    public void run() {

        try {
            while (!endGame) {
                this.setRandomState();

                if (this.safe)
                    System.out.println("L'environement est bon.");
                else
                    System.out.println("L'environement n'est pas bon.");

                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
