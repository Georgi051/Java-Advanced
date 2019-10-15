package SetsAndMaps.exersice;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> symbolCount = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            symbolCount.putIfAbsent(symbol,0);
            symbolCount.put(symbol,symbolCount.get(symbol) + 1);
        }

        for (Map.Entry<Character, Integer> entry : symbolCount.entrySet()) {
            System.out.printf("%c: %d time/s\n",entry.getKey(),entry.getValue());
        }
    }
}
