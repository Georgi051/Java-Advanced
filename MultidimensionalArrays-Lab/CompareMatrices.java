package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] rowsAndCols = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int [][] firstMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] colData = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            firstMatrix[i] = colData;
        }

        rowsAndCols = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int [][] secondMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] colData = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            secondMatrix[i] = colData;
        }

        if (matrixAreEqual(firstMatrix,secondMatrix)){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

    private static boolean matrixAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix [row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}
