package FunctionalProgramming.exersice;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.stream().sorted((f,s) -> {
            int result = 0;
            if (f % 2 == 0 && s % 2 != 0){
                result = -1;
            }else if (f % 2 != 0 && s % 2 == 0 ){
                result = 1;
            }else {
                result = f - s;
            }
            return result ;
        }).forEach(e -> System.out.print(e + " "));
    }
}
