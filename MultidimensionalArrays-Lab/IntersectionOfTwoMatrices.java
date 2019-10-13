package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = fillMatrix(rows, cols, scanner);
        char[][] secondMatrix = fillMatrix(rows, cols, scanner);

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col]);
                } else {
                    System.out.print("*");
                }
                if (cols - 1 != col) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = data[col].charAt(0);
            }
        }
        return matrix;
    }
}


