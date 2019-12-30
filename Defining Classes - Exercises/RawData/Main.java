package DefiningClassesExercise.RawData;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Car> carMap = new LinkedHashMap<>();

        while (n-- > 0){
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int speed = Integer.parseInt(carData[1]);
            int power = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);

            String cargoType = carData[4];
            List<Double> tiers = new ArrayList<>();
            for (int i = 5; i < carData.length; i+=2) {
                tiers.add(Double.parseDouble(carData[i]));
            }
           Engine engine = new Engine(speed,power);
           Cargo cargo = new Cargo(cargoWeight,cargoType);
           Tires tires = new Tires(tiers);
           Car car = new Car(model,engine,cargo,tires);

           carMap.put(model,car);
        }

        String cargoType = scanner.nextLine();
        if (cargoType.equals("fragile")){
            carMap.entrySet().stream().filter(car -> car.getValue().getCargoType().equals("fragile"))
                    .filter(car -> car.getValue().isCurrentPressure()).forEach(car -> System.out.println(car.getValue()));
        }else {
            carMap.entrySet().stream().filter(car -> car.getValue().getCargoType().equals("flamable"))
                    .filter(car -> car.getValue().checkEngine()).forEach(car -> System.out.println(car.getValue()));
        }
    }
}
