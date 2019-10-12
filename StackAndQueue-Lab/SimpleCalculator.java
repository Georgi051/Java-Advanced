package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = data.length - 1; i >= 0; i--) {
            stack.push(data[i]);
        }
        while (stack.size() > 1){
            int firstElement = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secElement = Integer.parseInt(stack.pop());

            if (operator.equals("+")){
                int sum = firstElement + secElement;
                stack.push(String.valueOf(sum));
            }else {
                int sum = firstElement - secElement;
                stack.push(String.valueOf(sum));
            }
        }
        System.out.println(stack.getFirst());
    }
}
