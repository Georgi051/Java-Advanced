package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> nums = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        nums.stream().map(e -> e * 1.20).forEach(e -> System.out.printf("%.2f\n", e));
    }
}
