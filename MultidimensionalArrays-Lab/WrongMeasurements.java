package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[n][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int [] mistakeValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int row = mistakeValue[0];
        int col = mistakeValue[1];

        int wrongValue = matrix[row][col];

        int [][] resultMatrix = new int[n][];

        for (int i = 0; i < n; i++) {
            resultMatrix = matrix.clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != wrongValue){
                    resultMatrix[i][j] = matrix[i][j];
                }else {
                    resultMatrix[i][j] = getSum(matrix,i,j,wrongValue);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;

        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue){
            sum += matrix[row - 1][col];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue){
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue){
            sum += matrix[row][col - 1];
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue){
            sum += matrix[row][col + 1];
        }

        return sum;
    }
}
