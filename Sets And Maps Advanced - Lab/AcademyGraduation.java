package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsBook = new TreeMap<>();
        while (n-- > 0){
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());
            studentsBook.putIfAbsent(studentName,grades);

        }
        for (Map.Entry<String, List<Double>> stringEntry : studentsBook.entrySet()) {
            List<Double> value = stringEntry.getValue();
            double sum = 0;
            for (double v : value) {
                sum += v;
            }
            double avg = sum / value.size();
            System.out.printf("%s is graduated with %s%n",stringEntry.getKey(),avg);
        }
    }
}
