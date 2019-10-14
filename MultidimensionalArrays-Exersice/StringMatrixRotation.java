package MultidimensionalArrays.exracise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("[( )]");
        int degrees = Integer.parseInt(data[1]) % 360;

        List<String> words = new ArrayList<>();
        int longestWord = 0;
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            words.add(input);
            if (input.length() > longestWord) {
                longestWord = input.length();
            }
            input = scanner.nextLine();
        }

        char[][] matrix = new char[words.size()][longestWord];
        fillMatrix(matrix, words);

        if (degrees == 90) {
            for (int c = 0; c < longestWord; c++) {
                for (int r = matrix.length - 1; r >= 0 ; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                for (int c = longestWord - 1; c >= 0 ; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int c = longestWord - 1; c >= 0; c--) {
                for (int r = 0; r < matrix.length ; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {
        for (int r = 0; r < matrix.length; r++) {
            String word = words.get(r);
            for (int c = 0; c < matrix[r].length; c++) {
                if (word.length() > c) {
                    matrix[r][c] = word.charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
    }
}
