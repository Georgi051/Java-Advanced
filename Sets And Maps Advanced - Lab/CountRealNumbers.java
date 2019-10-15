package SetsAndMaps;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer> numberBook = new LinkedHashMap<>();

        for (double value : nums) {
            if (!numberBook.containsKey(value)) {
                numberBook.put(value, 1);
            } else {
                numberBook.put(value, numberBook.get(value) + 1);
            }
        }
        for (Map.Entry<Double, Integer> num : numberBook.entrySet()) {
            System.out.printf("%.1f -> %d%n",num.getKey(),num.getValue());
        }
    }
}
