package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        List<Box<String>> stringBoxList = new ArrayList<>();

        while (n-- > 0){
            String input = scanner.nextLine();

            Box box = new Box<>(input);
            stringBoxList.add(box);

        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        printResult(stringBoxList,indexes);
        for (Box<String> stringBox : stringBoxList) {
            System.out.println(stringBox.toString());
        }

    }

    private static <T> void  printResult(List<T> stringBoxList, int[] indexes) {
        T temp = stringBoxList.get(indexes[0]);
        stringBoxList.set(indexes[0],stringBoxList.get(indexes[1]));
        stringBoxList.set(indexes[1],temp);
    }
}
