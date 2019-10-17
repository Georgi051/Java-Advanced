package SetsAndMaps.exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([A-Za-z ]+)\\s@([A-Za-z ]+)\\s(\\d+)\\s(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, LinkedHashMap<String, Long>> book = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singer = matcher.group(1);
                String venue = matcher.group(2);
                long ticketPrice = Long.parseLong(matcher.group(3));
                long ticketCount = Long.parseLong(matcher.group(4));
                long totalMoney = ticketPrice * ticketCount;

                book.putIfAbsent(venue, new LinkedHashMap<>());
                if (!book.get(venue).containsKey(singer)) {
                    book.get(venue).put(singer, totalMoney);
                } else {
                    book.get(venue).put(singer, book.get(venue).get(singer) + totalMoney);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Long>> bookEntry : book.entrySet()) {
            System.out.println(bookEntry.getKey());
            bookEntry.getValue().entrySet().stream().sorted((e1, e2) ->
                    e2.getValue().compareTo(e1.getValue())
            ).forEach(entry -> System.out.printf("#  %s -> %d\n", entry.getKey(), entry.getValue()));
        }
    }
}
