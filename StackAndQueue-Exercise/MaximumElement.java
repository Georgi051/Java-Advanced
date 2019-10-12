package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        while (n-- > 0){
            String[] data = scanner.nextLine().split("\\s+");

            String command = data[0];

            switch (command){
                case "1":
                    int element = Integer.parseInt(data[1]);
                    nums.push(element);
                    break;
                case "2":
                    nums.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(nums));
                    break;
            }
        }
    }
}
