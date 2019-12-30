package OldExamTasks;

import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();

        for (int num : first) {
            leftSocks.push(num);
        }
        for (int num : second) {
            rightSocks.offer(num);
        }
        List<Integer> pair = new ArrayList<>();
        while (leftSocks.size() > 0 && rightSocks.size() > 0) {
            int left = leftSocks.pop();
            int right = rightSocks.poll();

            if (right < left) {
                pair.add(left + right);
            } else if (right > left) {
                rightSocks.push(right);
            } else {
                leftSocks.push(left + 1);
            }
        }
        System.out.println(Collections.max(pair));
        pair.forEach(e -> System.out.print(e + " "));
    }
}
