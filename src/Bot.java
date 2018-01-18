import java.util.concurrent.TimeUnit;

public class Bot {
    private BotGoal goal;

    public Bot(BotGoal goal) {
        this.goal = goal;
    }

    public BotGoal getGoal() {
        return goal;
    }

    public void setGoal(BotGoal goal) {
        this.goal = goal;
    }

    public void Update() throws  InterruptedException{



        goal.Process();
        TimeUnit.SECONDS.sleep(2);
        goal.Terminate();
    }
}
