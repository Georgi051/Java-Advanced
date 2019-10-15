package SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carPlate = new HashSet<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] data = input.split(", ");
            String typeCommand = data[0];
            String plateNum = data[1];
            if (typeCommand.equals("IN")){
                carPlate.add(plateNum);
            }else {
                carPlate.remove(plateNum);
            }
            input = scanner.nextLine();
        }
        if (!carPlate.isEmpty()){
            for (String num : carPlate) {
                System.out.println(num);
            }
        }else {
            System.out.println("Parking Lot is Empty");
        }

    }
}
