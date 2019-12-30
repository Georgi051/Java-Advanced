package DefiningClassesExercise.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        while (n-- > 0) {
            String[] personData = scanner.nextLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            Person person = new Person(name);
            personList.add(person);

        }
        personList.sort(Comparator.comparing(Person::getName));
       // personList.sort((f,s)-> f.getName().compareTo(s.getName()));

        personList.stream().filter(e -> e.getAge() > 30)
                .forEach(person -> System.out.printf("%s - %d%n",
                        person.getName(),person.getAge()));

    }
}
