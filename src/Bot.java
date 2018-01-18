public class Bot {
    private BotGoalEnum goal;

    public Bot(BotGoalEnum goal) {
        this.goal = goal;
    }

    public BotGoalEnum getGoal() {
        return goal;
    }

    public void setGoal(BotGoalEnum goal) {
        this.goal = goal;
    }
}
