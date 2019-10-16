package SetsAndMaps.exersice;

        import java.util.Arrays;
        import java.util.Scanner;
        import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> compounds = new TreeSet<>();

        while (n-- > 0){
            String[] input = scanner.nextLine().split("\\s+");
            compounds.addAll(Arrays.asList(input));
        }

        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
    }
}
