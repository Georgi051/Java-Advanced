package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(1L);
        stack.push(1L);
        while (n-- > 1){
            long a = stack.pop();
            long b = stack.pop();
            long c = a + b;
            stack.push(b);
            stack.push(a);
            stack.push(c);
        }
        System.out.println(stack.pop());
    }
}
