package FunctionalProgramming.exersice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>,Integer> smallestNum = integerList -> {
            int minNum = integerList.get(0);
            for (int i = 1; i < integerList.size(); i++) {
                if (integerList.get(i) < minNum){
                    minNum = integerList.get(i);
                }
            }
            return minNum;
        };

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(smallestNum.apply(numbers));
    }
}
