package SetsAndMaps.exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> mineralsBook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)){
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            mineralsBook.putIfAbsent(resource,0);
            mineralsBook.put(resource,mineralsBook.get(resource) + quantity);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : mineralsBook.entrySet()) {
            System.out.printf("%s -> %d\n",entry.getKey(),entry.getValue());
        }
    }
}
