package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] colsData = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = colsData;
        }
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int currentSum = sumFromTop(matrix,i,j);
                if (currentSum > max){
                    max = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(matrix[maxRow + r][maxCol + c] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }

    private static int sumFromTop(int matrix[][], int row, int col){
        return matrix[row][col] +
                matrix[row + 1][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col + 1];
    }
}
