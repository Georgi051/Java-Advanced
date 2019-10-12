package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String datum : data) {
            queue.offer(datum);
        }

        int cycles = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < num; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycles)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycles++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
