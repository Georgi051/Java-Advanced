package OldExamTasks;

import java.util.*;
import java.util.stream.Collectors;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waves = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> spartanDefence = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> warriors = new ArrayDeque<>();

        for (int i = 1; i <= waves; i++) {
            String[] inputWarriors = scanner.nextLine().split("\\s+");

            if (spartanDefence.size() == 0) {
                break;
            }
            if (i == 3) {
                int bonusDefence = Integer.parseInt(scanner.nextLine());
                spartanDefence.addLast(bonusDefence);
            }

            for (String inputWarrior : inputWarriors) {
                warriors.push(Integer.parseInt(inputWarrior));
            }

            while (warriors.size() > 0 && spartanDefence.size() > 0) {
                int currentWarrior = warriors.poll();
                int currentWall = spartanDefence.pop();

                int afterHit = 0;
                if (currentWarrior > currentWall) {
                    afterHit = currentWarrior - currentWall;
                    warriors.addFirst(afterHit);
                } else {
                    afterHit = currentWall - currentWarrior;
                    if (afterHit > 0) {
                        spartanDefence.addFirst(afterHit);
                    }
                }
            }
        }

        if (warriors.size() > 0) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            System.out.print(warriors.stream()
                    .map(e -> Integer.toString(e)).collect(Collectors.joining(", ")));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            System.out.print(spartanDefence.stream()
                    .map(e -> Integer.toString(e)).collect(Collectors.joining(", ")));
        }
    }
}
