package SetsAndMaps.exersice;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, HashSet<String>> book = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"JOKER".equals(input)) {
            String[] data = input.split(": ");
            String name = data[0];
            List<String> cards = Arrays.stream(data[1].split(", "))
                    .collect(Collectors.toList());

            book.putIfAbsent(name, new HashSet<>());
            book.get(name).addAll(cards);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : book.entrySet()) {
            Set<String> cards = entry.getValue();
            int totalSum = 0;
            for (String card : cards) {
                int sumCards = firstCharacter(card) * secCharacter(card);
                totalSum += sumCards;
            }
            System.out.printf("%s: %d\n", entry.getKey(), totalSum);
        }
    }

    private static int firstCharacter(String card) {
        int sum = 0;
        String currCard = "";
        if (card.length() == 3) {
            currCard += card.substring(0, card.length() - 1);
        } else if (card.length() == 2){
            currCard += card.charAt(0);
        }

        if (currCard.equals("J")) {
            sum = 11;
        } else if (currCard.equals("Q")) {
            sum = 12;
        } else if (currCard.equals("K")) {
            sum = 13;
        } else if (currCard.equals("A")) {
            sum = 14;
        } else {
            sum = Integer.parseInt(currCard);
        }
        return sum;
    }
    private static int secCharacter(String card) {
        int sum = 0;
        String currCard = "";
        if (card.length() == 3) {
            currCard += card.substring(card.length() - 1);
        } else if (card.length() == 2){
            currCard += card.charAt(1);
        }

        if (currCard.equals("S")) {
            sum = 4;
        } else if (currCard.equals("H")) {
            sum = 3;
        } else if (currCard.equals("D")) {
            sum = 2;
        } else if (currCard.equals("C")) {
            sum = 1;
        }
        return sum;
    }
}
