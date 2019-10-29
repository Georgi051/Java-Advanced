package FunctionalProgramming.exersice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Map<String, Predicate<String>> stringMap = new HashMap<>();

        String command = scanner.nextLine();
        while (!"Party!".equals(command)) {
            String predicate = command.substring(command.indexOf(" ") + 1);
            stringMap.putIfAbsent(command, generatePredicate(predicate));
            command = scanner.nextLine();
        }

        for (var kvp : stringMap.entrySet()) {
            if (kvp.getKey().contains("Remove")) {
                names.removeIf(kvp.getValue());
            } else {
                List<String> doubleNames = names.stream().filter(kvp.getValue())
                        .collect(Collectors.toList());
                names.addAll(doubleNames);
            }
        }
        Collections.sort(names);
        if (!names.isEmpty()) {
            System.out.println(String.join(", ", names) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> generatePredicate(String predicate) {
        String[] data = predicate.split(" ");
        String criteria = data[0];
        String parameter = data[1];

        Predicate<String> stringPredicate = null;

        if (criteria.equals("StartsWith")) {
            stringPredicate = name -> name.startsWith(parameter);
        } else if (criteria.equals("EndsWith")) {
            stringPredicate = name -> name.endsWith(parameter);
        } else if (criteria.equals("Length")) {
            stringPredicate = name -> name.length() == Integer.parseInt(parameter);
        }
        return stringPredicate;
    }
}
