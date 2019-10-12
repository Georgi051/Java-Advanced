package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals("print")){
            if (command.equals("cancel")){
                if (!queue.isEmpty()){
                    System.out.println("Canceled " + queue.poll());
                }else {
                    System.out.println("Printer is on standby");
                }
            }else {
                queue.offer(command);
            }
            command = scanner.nextLine();
        }
        if (!queue.isEmpty()){
            while (!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        }
    }
}
