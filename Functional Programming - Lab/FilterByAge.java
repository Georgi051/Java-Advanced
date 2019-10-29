package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> peopleAndYears = new LinkedHashMap<>();

        BiPredicate<Map.Entry<String,Integer>, Integer> youngerThen =
                (person , age) -> person.getValue() <= age;
        BiPredicate<Map.Entry<String,Integer>, Integer> olderThen =
                (person , age) -> person.getValue() >= age;

        Consumer<Map.Entry<String,Integer>> printOnlyName =
                person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String,Integer>> printOnlyAge =
                person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String,Integer>> printNameAndAge =
                person -> System.out.printf("%s - %d%n",person.getKey(),person.getValue());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            peopleAndYears.put(name, age);
        }
        String condition = scanner.nextLine();
        int years = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        peopleAndYears.entrySet().stream().filter(person ->
                condition.equals("younger") ?
                youngerThen.test(person,years) :
                olderThen.test(person,years)
        ).forEach(person -> {
            if (format.equals("name")){
                printOnlyName.accept(person);
            }else if (format.equals("age")){
                printOnlyAge.accept(person);
            }else {
                printNameAndAge.accept(person);
            }
        });
    }
}
