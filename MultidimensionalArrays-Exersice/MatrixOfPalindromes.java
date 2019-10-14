package MultidimensionalArrays.exracise;

        import java.util.Arrays;
        import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowSize = inputData[0];
        int colSize = inputData[1];

        String[][] matrix = new String[rowSize][colSize];

        fillMatrix(matrix, rowSize, colSize);
        printMatrix(matrix, rowSize, colSize);

    }

    private static void printMatrix(String[][] matrix, int rowSize, int colSize) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, int rowSize, int colSize) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                String firstSymbol = "" + (char) ('a' + row) +
                        (char) ('a' + row + col) +
                        (char) ('a' + row);

                matrix[row][col] = firstSymbol;
            }
        }
    }
}
