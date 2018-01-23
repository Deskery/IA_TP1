
import java.util.concurrent.TimeUnit;

public class Environment extends Thread {
    private String threadName;
    private boolean safe;
    private boolean endGame;


    public Environment(String threadName) {
        this.safe = true;
        this.endGame = false;
        this.threadName = threadName;

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
