public class BotSensor {
    private Environment environment;

    public BotSensor(Environment environment) {
        this.environment = environment;
    }

    public boolean isEnvironmentSafe() {
        return environment.isSafe();
    }
}
