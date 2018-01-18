import java.io.IOException;
import java.io.PipedInputStream;
import java.util.concurrent.TimeUnit;

public class Bot extends Thread {
    private BotGoal goal;
    private BotGoal storedGoal;
    private Wait wait;
    private String threadName;
    private boolean endGame;
    private int in;
    private PipedInputStream input;

    public Bot(String threadName,PipedInputStream in) {
        this.goal = new A1(this);
        this.threadName = threadName;
        this.endGame = false;
        this.input = in;
        this.wait = new Wait(this);
    }

    public void setEndGame() {
        this.endGame = true;

    }

    public BotGoal getGoal() {
        return goal;
    }

    public void setGoal(BotGoal goal) {
        this.goal = goal;
    }

    private void Update() {

        try{
            this.in = input.read();
        } catch (IOException e){ e.printStackTrace();}

        // 1 = environment is not safe
        if(in == 1 && goal != wait)
        {
            storedGoal = goal;
            setGoal(wait);
        }

        // 0 = environment is safe
        if(in == 0)
        {
            // If the bot was waiting the bad conditions to pass
            if (goal instanceof Wait) {
                System.out.println("plopiploupi");
                goal = storedGoal;
            }


            System.out.println("plopiploup");
        }

        goal.Process();
        goal.Display();
        try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {}
        goal.Terminate();

    }

    @Override
    public void run() {
        while (!endGame) {
           Update();
        }
    }
}
