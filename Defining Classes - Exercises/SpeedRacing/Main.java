package DefiningClassesExercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double costForOneKm = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, costForOneKm);
            cars.add(car);
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] carDriveInfo = command.split("\\s+");
            String currentCar = carDriveInfo[1];
            int kmToDrive = Integer.parseInt(carDriveInfo[2]);

            for (Car car : cars) {
                if (car.getModel().equals(currentCar)){
                    if (!car.isValidToDrive(kmToDrive)){
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            command = scanner.nextLine();
        }
        cars.forEach(car -> System.out.println(car.toString()));
    }
}
