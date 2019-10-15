package SetsAndMaps;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();
        String firstInput = scanner.nextLine();
        while (!"PARTY".equals(firstInput)) {
            if (firstInput.length() == 8) {
                guest.add(firstInput);
            }
            firstInput = scanner.nextLine();
        }
        String secInput = scanner.nextLine();
        while (!"END".equals(secInput)) {
            guest.remove(secInput);
            secInput = scanner.nextLine();
        }
        System.out.println(guest.size());
        for (String vip : guest) {
            System.out.println(vip);
        }
    }
}
