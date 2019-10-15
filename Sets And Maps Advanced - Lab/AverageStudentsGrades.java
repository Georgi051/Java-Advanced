package SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> studentsBook = new TreeMap<>();
        while (n-- > 0){
            String[] input = scanner.nextLine().split("\\s+");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentsBook.containsKey(student)){
                List<Double> grades = new ArrayList<>();
                grades.add(grade);
                studentsBook.put(student,grades);
            }else {
                List<Double> grades = studentsBook.get(student);
                grades.add(grade);
                studentsBook.put(student,grades);
            }
        }

        for (Map.Entry<String, List<Double>> stringListEntry : studentsBook.entrySet()) {
            List<Double> gradesEntry = stringListEntry.getValue();
            double avg = gradesEntry.stream().mapToDouble(value -> value)
                    .average().orElse(gradesEntry.get(0));

            System.out.printf("%s -> ",stringListEntry.getKey());
            for (Double grade : gradesEntry) {
                System.out.printf("%.2f ",grade);
            }
            System.out.printf("(avg: %.2f)%n",avg);
        }
    }
}
