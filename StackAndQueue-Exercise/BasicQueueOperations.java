package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsCountToAdd = parameters[0];
        int removeElements = parameters[1];
        int presentElement = parameters[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsCountToAdd)
                .forEach(numbers::offer);

        while (removeElements-- > 0){
            numbers.poll();
        }

        if (numbers.contains(presentElement)){
            System.out.println("true");
        }else {
            if (numbers.size() == 0){
                System.out.println(0);
            }else {
                System.out.println(Collections.min(numbers));
            }
        }


    }
}
