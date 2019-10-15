package SetsAndMaps;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Double>> shopBook = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            if (!shopBook.containsKey(shop)) {
                shopBook.put(shop, new LinkedHashMap<>());
            }
            HashMap<String, Double> productAndValue = shopBook.get(shop);
            productAndValue.put(product,price);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> stringHashMapEntry : shopBook.entrySet()) {
            System.out.printf("%s->%n",stringHashMapEntry.getKey());
            Map<String,Double> productAndValue = stringHashMapEntry.getValue();
            for (Map.Entry<String, Double> valueEntry : productAndValue.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",valueEntry.getKey(),valueEntry.getValue());
            }
        }
    }
}

