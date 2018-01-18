
import jdk.nashorn.internal.ir.CatchNode;

import java.io.IOException;
import java.io.PipedInputStream;
import java.util.concurrent.TimeUnit;

public class Bot extends Thread {
    private BotGoal goal;
    private BotGoal mem;
    private Wait wait;
    private String threadName;
    private int in;

    public Bot(String threadName,PipedInputStream in) {
        this.goal = new A1(this);
        this.threadName = threadName;
        wait = new Wait(this);

        try{
            this.in = in.read();
        } catch (IOException e){ e.printStackTrace();}
    }

    public BotGoal getGoal() {
        return goal;
    }

    public void setGoal(BotGoal goal) {
        this.goal = goal;
    }

    public void Update() {

        if(in == 1 && goal != wait)
        {
            mem = goal;
            setGoal(wait);
        }

        if(goal == wait && in == 0)
        {
            goal = mem;
        }

        goal.Process();
        try
        {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {}
        goal.Terminate();

    }

    @Override
    public void run() {
            Update();
    }
}
