package SetsAndMaps.exersice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> contactBook = new HashMap<>();

        String input = scanner.nextLine();
        while (!"search".equals(input)){
            String[] contact= input.split("-");
            String name = contact[0];
            String number = contact[1];

            contactBook.putIfAbsent(name,number);
            contactBook.put(name,number);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"stop".equals(input)){
            String name = input;
            if (!contactBook.containsKey(name)){
                System.out.printf("Contact %s does not exist.%n",name);
            }else {
                System.out.printf("%s -> %s\n",name,contactBook.get(name));
            }
            input = scanner.nextLine();
        }
    }
}
