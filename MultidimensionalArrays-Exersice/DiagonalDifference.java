package MultidimensionalArrays.exracise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(biggestDiagonalSum(matrix));
    }

    private static int biggestDiagonalSum(int[][] matrix) {
        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col){
                    sumFirstDiagonal += matrix[row][col];
                }
                if (row == matrix.length - col - 1){
                    sumSecondDiagonal += matrix[row][col];
                }
            }
        }
        return Math.abs(sumFirstDiagonal - sumSecondDiagonal);
    }
}
