package OldExamTasks.tasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] maleData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] femaleData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> male = new ArrayDeque<>();
        ArrayDeque<Integer> female = new ArrayDeque<>();

        for (Integer integer : maleData) {
            male.push(integer);
        }
        for (Integer integer : femaleData) {
            female.offer(integer);
        }
        int matchCount = 0;
        while (!male.isEmpty() && !female.isEmpty()){
            int currentMale = male.peek();
            int currentFemale = female.peek();

            if (currentMale <= 0){
                male.pop();
                continue;
            }else if (currentMale % 25 == 0){
                male.pop();
                male.pop();
                continue;
            }

            if (currentFemale <= 0){
                female.poll();
                continue;
            }else if (currentFemale % 25 == 0){
                female.poll();
                female.poll();
                continue;
            }

            if (currentMale == currentFemale){
                matchCount += 1;
                male.pop();
                female.poll();
            }else {
                male.pop();
                female.poll();
                if (currentMale - 2 > 0){
                    male.push(currentMale - 2);
                }
            }
        }
        System.out.printf("Matches: %d%n",matchCount);
        if (male.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.print("Males left: ");
            System.out.println(male.toString().replaceAll("[\\[\\]]", ""));
        }

        if (female.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.print("Females left: ");
            System.out.println(female.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
