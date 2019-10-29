package FunctionalProgramming.exersice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        UnaryOperator<int[]> add = arr -> Arrays.stream(arr).map(num -> ++num).toArray();
        UnaryOperator<int[]> sub = arr -> Arrays.stream(arr).map(num -> --num).toArray();
        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr).map(num -> num *= 2).toArray();
        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = sub.apply(numbers);
                    break;
                default:
                    print.accept(numbers);
                    System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}
