package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurementsSecondWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int [] dataIndex = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int wrongValue = matrix[dataIndex[0]][dataIndex[1]];
        ArrayList<Integer> sumNumbers = new ArrayList<>();
        ArrayList<int[]> matrixRow = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue){
                    int validValue = validValue(matrix,r,c,wrongValue);
                    sumNumbers.add(validValue);
                    matrixRow.add(new int[]{r,c});
                }
            }
        }
        for (int i = 0; i < sumNumbers.size(); i++) {
            matrix[matrixRow.get(i)[0]][matrixRow.get(i)[1]] = sumNumbers.get(i);
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int validValue(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;
        if (isValidIndex(matrix,row + 1, col) && matrix[row + 1][col] != wrongValue){
            sum += matrix[row + 1][col];
        }
        if (isValidIndex(matrix,row - 1, col) && matrix[row - 1][col] != wrongValue){
            sum += matrix[row - 1][col];
        }
        if (isValidIndex(matrix,row, col + 1) && matrix[row][col + 1] != wrongValue){
            sum += matrix[row][col + 1];
        }
        if (isValidIndex(matrix,row, col - 1) && matrix[row][col - 1] != wrongValue){
            sum += matrix[row][col - 1];
        }

        return sum;
    }

    private static boolean isValidIndex(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
