package SetsAndMaps.exersice;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> items = new LinkedHashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);

        String bestMaterial = "";
        boolean isFound = false;
        while (true) {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int i = 0; i < inputData.length; i += 2) {
                String item = inputData[i + 1].toLowerCase();
                int quantity = Integer.parseInt(inputData[i]);
                if (items.containsKey(item)) {
                    items.put(item, items.get(item) + quantity);
                    if (items.get(item) >= 250) {
                        int value = items.get(item) - 250;
                        items.put(item, value);
                        bestMaterial = item;
                        isFound = true;
                        break;
                    }
                } else {
                    if (!junk.containsKey(item)) {
                        junk.put(item, quantity);
                    } else {
                        junk.put(item, junk.get(item) + quantity);
                    }
                }
            }
            if (isFound) {
                break;
            }
        }
        if (bestMaterial.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (bestMaterial.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        } else if (bestMaterial.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        }
        items.entrySet().stream().sorted((e1, e2) -> {
            int value = e2.getValue().compareTo(e1.getValue());
            if (value == 0) {
                value = e1.getKey().compareTo(e2.getKey());
            }
            return value;
        }).forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
        junk.forEach((key, value) -> System.out.printf("%s: %d\n",
                key, value));
    }
}
