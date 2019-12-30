package DefiningClassesExercise.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person_> personMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String name = data[0];
            personMap.putIfAbsent(name, new Person_(name));

            Person_ person = personMap.get(name);
            Company company;
            Car car;
            Pokemon pokemon;
            Parents parents;
            Children children;
            if (data[1].equals("company")) {
                double salary = Double.parseDouble(data[4]);
                company = new Company(data[2], data[3], salary);
                person.setCompany(company);
            } else if (data[1].equals("pokemon")) {
                pokemon = new Pokemon(data[2], data[3]);
                person.add(pokemon);
            } else if (data[1].equals("parents")) {
                parents = new Parents(data[2], data[3]);
                person.add(parents);
            } else if (data[1].equals("children")) {
                children = new Children(data[2], data[3]);
                person.add(children);
            } else {
                car = new Car(data[2], data[3]);
                person.setCar(car);
            }
            input = scanner.nextLine();
        }
        String name = scanner.nextLine();


        printResult(personMap, name);
    }

    private static void printResult(Map<String, Person_> personMap, String name) {
        for (Person_ person : personMap.values()) {
            if (person.getName().equals(name)) {
                System.out.println(name);
                System.out.println("Company:");
                if (person.getCompany() != null) {
                    System.out.println(String.format("%s %s %.2f",
                            person.getCompany().getCompany()
                            , person.getCompany().getDepartment()
                            , person.getCompany().getSalary()));
                }
                System.out.println("Car:");
                if (person.getCar() != null) {
                    System.out.println(String.format("%s %s",
                            person.getCar().getModel(), person.getCar().getSpeed()));
                }
                System.out.println("Pokemon:");
                for (Pokemon pokemon : person.getPokemons()) {
                    System.out.println(pokemon);
                }
                System.out.println("Parents:");
                for (Parents parent : person.getParents()) {
                    System.out.println(parent);
                }
                System.out.println("Children:");
                for (Children child : person.getChildren()) {
                    System.out.println(child);
                }
            }
        }
    }
}
