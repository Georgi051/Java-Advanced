package GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Integer>> intBoxList = new ArrayList<>();

        while (n-- > 0) {
            String input = scanner.nextLine();

            Box box = new Box<Integer>(Integer.parseInt(input));
            intBoxList.add(box);
        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        printResult(intBoxList, indexes);
        for (Box<Integer> intBox : intBoxList) {
            System.out.println(intBox.toString());
        }
    }

    private static <T> void printResult(List<T> intBoxList, int[] indexes) {
        T temp = intBoxList.get(indexes[0]);
        intBoxList.set(indexes[0], intBoxList.get(indexes[1]));
        intBoxList.set(indexes[1], temp);
    }
}

