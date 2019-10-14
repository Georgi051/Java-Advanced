package MultidimensionalArrays.exracise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(", ");
        int size = Integer.parseInt(inputData[0]);
        String patternType = inputData[1];

        int[][] matrix = new int[size][size];

        if (patternType.equals("A")) {
            firstType(matrix);
        } else {
            secondType(matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void secondType(int[][] matrix) {
        int startNumMatrix = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumMatrix++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumMatrix++;
                }
            }
        }
    }

    private static void firstType(int[][] matrix) {
        int startNumMatrix = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumMatrix++;
            }
        }
    }
}
