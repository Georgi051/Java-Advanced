package FunctionalProgramming.exersice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNum = number -> {
            int minNum = Collections.min(numbers);
            return number.lastIndexOf(minNum);
        };
        System.out.println(smallestNum.apply(numbers));
    }
}
