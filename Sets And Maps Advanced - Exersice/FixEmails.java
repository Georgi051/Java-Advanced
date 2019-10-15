package SetsAndMaps.exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String ,String> emailBook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)){
            String name = input;
            String email = scanner.nextLine();
            String[] checkUrl = email.split("[.]");
            String url = checkUrl[1];
            if (url.equals("bg")){
                emailBook.put(name,email);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : emailBook.entrySet()) {
            System.out.printf("%s -> %s\n",entry.getKey(),entry.getValue());
        }
    }
}
