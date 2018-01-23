import java.util.concurrent.TimeUnit;

public class Bot extends Thread {
//    private BotGoal goal;
    private Goal goal;
    private Goal previousGoal;
    private BotSensor botSensor;
//    private BotGoal storedGoal;
//    private Wait wait;
    private String threadName;
    private boolean endGame;
//    private int in;
//    private PipedInputStream input;

//    public Bot(String threadName,PipedInputStream in) {
    public Bot(String threadName, Environment environment) {
        this.goal = Goal.startingGoal;
        this.botSensor = new BotSensor(environment);
        this.threadName = threadName;
        this.endGame = false;
//        this.goal = new A1(this);
//        this.input = in;
//        this.wait = new Wait(this);
    }

    public void setEndGame() {
        this.endGame = true;
    }

//    public BotGoal getGoal() {
//        return goal;
//    }
//
//    public void setGoal(BotGoal goal) {
//        this.goal = goal;
//    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    private void updateGoal() {

        if (botSensor.isEnvironmentSafe()) {
            Goal newGoal = Goal.wait;

            if (goal == Goal.startingGoal)
                newGoal = Goal.walk;

            if(goal == Goal.walk)
                newGoal = Goal.eat;

            if(goal == Goal.eat)
                newGoal = Goal.dance;

            if(goal == Goal.dance)
                newGoal = Goal.drinkBeer;

            if(goal == Goal.drinkBeer)
                newGoal = Goal.walk;

            if(goal == Goal.wait)
                newGoal = previousGoal;

            goal = newGoal;
        }
        else if (goal != Goal.wait) {
            previousGoal = goal;
            goal = Goal.wait;
        }

    }

    private void processGoal() {

        if (goal == Goal.wait)
            System.out.println("Bot : Je vais attendre, c'est dangereux dehors !");
        if (goal == Goal.walk)
            System.out.println("Bot : Je vais marcher, il fait beau dehors !");
        if (goal == Goal.eat)
            System.out.println("Bot : Je vais manger un morceau, j'ai faim après cette balade !");
        if (goal == Goal.dance)
            System.out.println("Bot : J'ai envie de danser !");
        if (goal == Goal.drinkBeer)
            System.out.println("Bot : Danser m'a donné soif, je vais aller boire une bière !");

    }

    @Override
    public void run() {
        while (!endGame) {
           updateGoal();
           processGoal();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
