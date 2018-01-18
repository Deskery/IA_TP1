public class Environment {
    private boolean safe;

    public Environment(boolean safe) {
        this.safe = safe;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setRandomState() {
        double randomVar = Math.random();
        this.safe = randomVar >= 0.2;


    }
}
