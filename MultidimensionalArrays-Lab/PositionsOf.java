package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] numbersMatrix = new int[rows][cols];
        for (int row = 0; row < numbersMatrix.length; row++) {
            int[] colData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            numbersMatrix[row] = colData;
        }

        int searchNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < numbersMatrix.length; row++) {
            for (int col = 0; col < numbersMatrix[0].length; col++) {
                if (numbersMatrix[row][col] == searchNumber) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
