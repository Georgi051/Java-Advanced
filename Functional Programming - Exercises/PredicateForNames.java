package FunctionalProgramming.exersice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        BiPredicate<String, Integer> lengthCheck = (name, lengthName) -> name.length() <= lengthName;

        Arrays.stream(names).filter(name -> lengthCheck.test(name, length))
                .forEach(System.out::println);
    }
}
