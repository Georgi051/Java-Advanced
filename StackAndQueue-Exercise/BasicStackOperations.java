package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numElements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numElements[0])
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }
        for (int i = 0; i < numElements[1]; i++) {
            stack.pop();
        }

        if (stack.contains(numElements[2])){
            System.out.println("true");
        }else {
            if (stack.isEmpty()){
                System.out.println("0");
            }else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
