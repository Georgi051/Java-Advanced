package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int row = 0;
        int col = 0;
        while (row < matrix.length){
            int mainDiagonal = matrix[row++][col++];
            System.out.print(mainDiagonal + " ");
        }
        System.out.println();

        row = matrix.length - 1;
        col = 0;
        while (row >= 0){
            int secondDiagonal = matrix[row--][col++];
            System.out.print(secondDiagonal + " ");
        }
    }
}
