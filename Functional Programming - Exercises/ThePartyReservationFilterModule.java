package FunctionalProgramming.exersice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Map<String, Predicate<String>> predicateMap = new HashMap<>();

        String command = scanner.nextLine();
        while (!"Print".equals(command)) {
            String predicate = command.substring(command.indexOf(";") + 1);

            if (command.contains("Add")) {
                predicateMap.putIfAbsent(predicate, getPredicate(predicate));
            } else {
                predicateMap.remove(predicate);
            }
            command = scanner.nextLine();
        }
        names.forEach(n -> {
            boolean isValid = true;
            for (var kvp : predicateMap.entrySet()) {
                if (kvp.getValue().test(n)){
                    isValid = false;
                }
            }
            if (isValid){
                System.out.print(n + " ");
            }
        });
    }
    private static Predicate<String> getPredicate(String predicate) {
        String[] data = predicate.split(";");
        String filterTypes = data[0];
        String parameters = data[1];

        Predicate<String> predicateReturn = null;
        if (filterTypes.equals("Starts with")) {
            predicateReturn = name -> name.startsWith(parameters);
        } else if (filterTypes.equals("Ends with")) {
            predicateReturn = name -> name.endsWith(parameters);
        } else if (filterTypes.equals("Length")) {
            predicateReturn = name -> name.length() == Integer.parseInt(parameters);
        } else if (filterTypes.equals("Contains")) {
            predicateReturn = name -> name.contains(parameters);
        }
        return predicateReturn;
    }
}
