package MultidimensionalArrays.exracise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSumSecondWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = inputData[0];
        int cols = inputData[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int bestSum = 0;
        int bestRow = 0;
        int bestCow = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = findSum(matrix, row, col);
                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCow = col;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        for (int r = bestRow; r < bestRow + 3; r++) {
            for (int c = bestCow; c < bestCow + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int findSum(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int r = row; r <= row + 2; r++) {
            for (int c = col; c <= col + 2; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }
}
