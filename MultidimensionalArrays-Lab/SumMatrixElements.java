package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).sum();
        }
        System.out.printf("%d\n%d\n%d",rows,cols,sum);
    }
}
