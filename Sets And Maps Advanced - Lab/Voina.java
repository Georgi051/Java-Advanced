package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {
            int firstPlayerCard = getFirstCard(firstPlayerCards);
            firstPlayerCards.remove(firstPlayerCard);
            int secondPlayerCard = getSecondCard(secondPlayerCards);
            secondPlayerCards.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard){
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            }else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(firstPlayerCard);
                secondPlayerCards.add(secondPlayerCard);
            }
        }
        if (firstPlayerCards.size() < secondPlayerCards.size()){
            System.out.println("Second player win!");
        }else if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }
    }
    private static int getFirstCard(Set<Integer> firstPlayerCards) {
        int firstCard = 0;
        for (Integer firstPlayerCard : firstPlayerCards) {
            firstCard = firstPlayerCard;
            break;
        }
        return firstCard;
    }
    private static int getSecondCard(Set<Integer> secondPlayerCards) {
        int firstCard = 0;
        for (Integer secondPlayerCard : secondPlayerCards) {
            firstCard = secondPlayerCard;
            break;
        }
        return firstCard;
    }
}
