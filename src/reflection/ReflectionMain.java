package reflection;

import java.util.ArrayList;
import java.util.List;

public class ReflectionMain {
    public static void main(String[] args) {
//        Employee employee = new Employee(1,"anas",14000);
//        Employee employee1 = new Employee(2,"med",13000);
//        List employees = new ArrayList();
//        employees.add(employee);
//        employees.add(employee1);
//
//        XMLSerializer.serializeToXML(employees);
        Engine engine = new Engine(200,300,"engine1");
        Car bmw = new Car("bmw","model 1",2022,engine);
        Car mercedes = new Car("mercedes","model 2",2020,engine);
        List<Car> cars = new ArrayList<>();
        cars.add(bmw);
        cars.add(mercedes);
        XMLSerializer.serializeToXML(cars);

    }
}
