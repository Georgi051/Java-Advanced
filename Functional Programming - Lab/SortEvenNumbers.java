package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        printList(numbers);
        System.out.println();
        Collections.sort(numbers);
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() - 1) {
                System.out.print(numbers.get(i) + ", ");
            } else {
                System.out.print(numbers.get(i));
            }
        }
    }
}
