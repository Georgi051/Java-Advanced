package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"Home".equals(command)) {

            if (!command.equals("back")) {
                urls.push(command);
                System.out.println(command);
            } else {
                if (urls.size() > 1) {
                    urls.pop();
                    System.out.println(urls.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
            command = scanner.nextLine();
        }
    }
}
