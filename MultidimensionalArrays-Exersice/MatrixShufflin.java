package MultidimensionalArrays.exracise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShufflin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String [][] matix = new String[size[0]][size[1]];

        for (int r = 0; r < matix.length; r++) {
            matix[r] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] data = input.split("\\s+");

            if (data.length == 5 && input.contains("swap")){
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                if (checkIsCoordinatesValue(matix, row1,col1,row2,col2)) {
                    for (int r = 0; r < matix.length; r++) {
                        for (int c = 0; c < matix[r].length; c++) {
                            System.out.print(matix[r][c]+ " ");
                        }
                        System.out.println();
                    }
                }else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean checkIsCoordinatesValue(String[][] matix, int row1, int col1, int row2, int col2) {
        for (int r = 0; r < matix.length; r++) {
            for (int c = 0; c < matix[r].length; c++) {
                if (row1 >= 0 && row1 < matix.length && col1 >= 0 && col1 < matix[r].length
                        && row2 >= 0 && row2 < matix.length && col2 >= 0 && col2 < matix[r].length){
                    String temp = matix[row1][col1];
                    matix[row1][col1] = matix[row2][col2];
                    matix[row2][col2] = temp;
                    return true;
                }
            }
        }
        return false;
    }
}
