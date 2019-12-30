package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> stringBoxList = new ArrayList<>();

        while (n-- > 0) {
            String input = scanner.nextLine();

            Box box = new Box<>(input);
            stringBoxList.add(box);
        }
        String element = scanner.nextLine();
        Box<String> elementBox = new Box<>(element);
        System.out.println(printResult(stringBoxList, elementBox));
    }

    private static <T extends Comparable<T>> int printResult(List<Box<T>> listBoxes, Box<T> box) {
        int count = 0;
        for (Box<T> t : listBoxes) {
            if (t.compareTo(box) > 0) {
                count++;
            }
        }
        return count;
    }
}
