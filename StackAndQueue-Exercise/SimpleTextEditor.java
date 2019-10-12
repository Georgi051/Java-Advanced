package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> data = new ArrayDeque<>();
        String changedData = "";

        while (num-- > 0) {
            String[] inputData = scanner.nextLine().split("\\s+");
            switch (inputData[0]) {
                case "1":
                    String text = inputData[1];
                    data.push(changedData);
                    changedData += text;
                    break;
                case "2":
                    int deleteIndex = Integer.parseInt(inputData[1]);
                    data.push(changedData);
                    changedData = changedData.substring(0, changedData.length() - deleteIndex);
                    break;
                case "3":
                    int count = Integer.parseInt(inputData[1]);
                    System.out.println(changedData.charAt(count - 1));
                    break;
                case "4":
                    changedData = data.pop();
                    break;

            }
        }
    }
}
