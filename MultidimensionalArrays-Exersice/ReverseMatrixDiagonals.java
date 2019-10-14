package MultidimensionalArrays.exracise;

import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix,scanner);

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0){
            int r = row;
            int c = col;
            while (r >= 0 && c < cols){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1){
                col = 0;
                row--;
            }
        }
    }
    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
