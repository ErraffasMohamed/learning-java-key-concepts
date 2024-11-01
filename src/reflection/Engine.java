package reflection;

public class Engine {
    private String name;
    private int power;
    private int speed;

    public Engine(int speed, int power, String name) {
        this.speed = speed;
        this.power = power;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }
}
