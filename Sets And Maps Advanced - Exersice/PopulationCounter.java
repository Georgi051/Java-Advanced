package SetsAndMaps.exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> book = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] data = input.split("[|]");
            String country = data[1];
            String city = data[0];
            long population = Long.parseLong(data[2]);

            book.putIfAbsent(country, new LinkedHashMap<>());
            book.get(country).putIfAbsent(city, 0L);
            book.get(country).put(city, book.get(country).get(city) + population);
            input = scanner.nextLine();
        }

        book.entrySet().stream().sorted((e1, e2) ->
                Long.compare(e2.getValue().values().stream()
                                .mapToLong(Long::longValue).sum(),
                             e1.getValue().values().stream()
                                .mapToLong(Long::longValue).sum())
        ).forEach(entry -> {
            System.out.printf("%s (total population: %d)\n",entry.getKey(),
                    entry.getValue().values().stream().mapToLong(Long::longValue).sum());

            entry.getValue().entrySet().stream().sorted((city1,city2)->
                    city2.getValue().compareTo(city1.getValue())
                    ).forEach(city -> System.out.printf("=>%s: %d\n",city.getKey(),city.getValue()));
        });
    }
}
