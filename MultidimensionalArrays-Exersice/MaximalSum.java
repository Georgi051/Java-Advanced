package MultidimensionalArrays.exracise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    private static int sum = 0;
    private static int[][] tempMatrix = new int[3][3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputMatrixSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(inputMatrixSize[0]);
        int cols = Integer.parseInt(inputMatrixSize[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        int[][] bestMatrix = new int[3][3];
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                findBestMatrix(matrix,row,col);
                if (sum > maxSum){
                    maxSum = sum;
                    bestMatrix = tempMatrix;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(bestMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void findBestMatrix(int[][] matrix, int r, int c) {
        tempMatrix = new int[3][3];
        sum = 0;
        int matrixRow = 0;
        for (int row = r - 1; row <= r + 1; row++) {
            int matrixCol = 0;
            for (int col = c - 1; col <= c + 1; col++) {
                sum += matrix[row][col];
                tempMatrix[matrixRow][matrixCol++] = matrix[row][col];
            }
            matrixRow++;
        }
    }
}
