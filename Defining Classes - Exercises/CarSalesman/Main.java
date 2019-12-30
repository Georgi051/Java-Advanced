package DefiningClassesExercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String typeEngine = engineData[0];
            String power = engineData[1];

            Engine engine;
            switch (engineData.length) {
                case 2:
                    engine = new Engine(typeEngine,power);
                    engines.put(typeEngine,engine);
                    break;
                case 3:
                    engine = new Engine(typeEngine,power,engineData[2]);
                    engines.put(typeEngine,engine);
                    break;
                case 4:
                    engine = new Engine(typeEngine,power,engineData[2],engineData[3]);
                    engines.put(typeEngine,engine);
                    break;
            }
        }

        n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engineToGetInformation = carData[1];

            Engine engine = engines.get(engineToGetInformation);

            Car car;
            switch (carData.length) {
                case 2:
                    car = new Car(model, engine);
                    cars.add(car);
                    break;
                case 3:
                    car = new Car(model, engine, carData[2]);
                    cars.add(car);
                    break;
                case 4:
                    car = new Car(model, engine, carData[2], carData[3]);
                    cars.add(car);
                    break;
            }
        }
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
