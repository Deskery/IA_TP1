import java.util.concurrent.TimeUnit;

public class Bot extends Thread {
    private BotGoal goal;
    private String threadName;

    public Bot(String threadName) {
        this.goal = new A1(this);
        this.threadName = threadName;
    }

    public BotGoal getGoal() {
        return goal;
    }

    public void setGoal(BotGoal goal) {
        this.goal = goal;
    }

    public void Update() throws InterruptedException{

        goal.Process();
        TimeUnit.SECONDS.sleep(2);
        goal.Terminate();
    }

    @Override
    public void run() {

    }
}
