package FunctionalProgramming.exersice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toSet());

        Predicate<Integer> checker = num -> {
            for (Integer divisor : divisors) {
                if (num % divisor != 0){
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= n ; i++) {
            if (checker.test(i)){
                System.out.print(i + " ");
            }
        }
    }
}
