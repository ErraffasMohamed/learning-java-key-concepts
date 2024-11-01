package reflection;

public class Car {
    private String make;
    private String model;
    private int year;
    private Engine engine;
    public Car(String make, String model, int year, Engine engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
