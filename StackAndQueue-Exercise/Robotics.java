package StackAndQueue.exercise;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dataInput = scanner.nextLine().split(";");

        String[] robots = new String[dataInput.length];
        int[] processTime = new int[dataInput.length];
        int[] workingTime = new int[dataInput.length];
        String time = scanner.nextLine();

        for (int i = 0; i < dataInput.length; i++) {
            String[] robotsData = dataInput[i].split("-");
            robots[i]= robotsData[0];
            processTime[i] = Integer.parseInt(robotsData[1]);
        }
        ArrayDeque<String> products = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!"End".equals(command)){
            products.offer(command);
            command = scanner.nextLine();
        }

        String[] timeData = time.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        long timeInSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()){
            timeInSeconds++;
            String product = products.poll();

            boolean isBusy = false;
            for (int i = 0; i < robots.length; i++) {
                if (workingTime[i] == 0 && !isBusy){
                    workingTime[i] = processTime[i];
                    isBusy = true;
                    System.out.println(printResult(robots[i], product, timeInSeconds));
                }
                if (workingTime[i] > 0){
                    workingTime[i]--;
                }
            }
            if (!isBusy){
                products.offer(product);
            }
        }
    }

    private static String printResult(String robot, String product, long timeInSeconds) {
        long s = timeInSeconds % 60;
        long m = (timeInSeconds / 60) % 60;
        long h = (timeInSeconds / (60 * 60)) % 24;
        return String.format("%s - %s [%02d:%02d:%02d]",robot,product,h,m,s);
    }
}
