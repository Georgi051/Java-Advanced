package OldExamTasks;

import java.util.*;
import java.util.stream.Collectors;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());

        String[] data = scanner.nextLine().split(" ");
        ArrayDeque<String> reservationAndHalls = new ArrayDeque<>();
        List<Integer> reservations = new ArrayList<>();

        for (String datum : data) {
            reservationAndHalls.push(datum);
        }

        ArrayDeque<Character> halls = new ArrayDeque<>();
        while (!reservationAndHalls.isEmpty()){
            String current = reservationAndHalls.poll();
            if (Character.isDigit(current.charAt(0))){
                int numPeople = Integer.parseInt(current);

                if (numPeople > capacity || halls.isEmpty()){
                    continue;
                }
                int sum = reservations.stream().reduce(0, Integer::sum);
                if (sum + numPeople <= capacity){
                    reservations.add(numPeople);
                }else {
                    printReservation(halls.poll(),reservations);
                    reservations.clear();
                    if (!halls.isEmpty()){
                        reservations.add(numPeople);
                    }
                }
            }else {
                halls.offer(current.charAt(0));
            }
        }
    }

    private static void printReservation(Character hall, List<Integer> reservations) {
        System.out.printf("%c -> ",hall);
        System.out.println(reservations.stream().
                map(e -> Integer.toString(e)).collect(Collectors.joining(", ")));
    }
}
