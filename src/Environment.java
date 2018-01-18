import java.util.concurrent.TimeUnit;

public class Environment extends Thread {
    private String threadName;

    private boolean safe;

    public Environment(boolean safe, String threadName) {
        this.safe = safe;
        this.threadName = threadName;
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
            while (true) {
                this.setRandomState();

                if (this.safe)
                    System.out.println("Environment is OK");
                else
                    System.out.println("Environment is not OK");
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
