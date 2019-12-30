package OldExamTasks;

import java.util.Scanner;

public class HelenAbductionSec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parisRow = 0;
        int parisCol = 0;

        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();

            if (input.contains("P")) {
                parisRow = i;
                parisCol = input.indexOf('P');
            }
        }
        while (energy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            int spartanRow = Integer.parseInt(tokens[1]);
            int spartanCol = Integer.parseInt(tokens[2]);
            matrix[spartanRow][spartanCol] = 'S';
            matrix[parisRow][parisCol] = '-';
            switch (direction) {
                case "up":
                    parisRow--;
                    break;
                case "down":
                    parisRow++;
                    break;
                case "left":
                    parisCol--;
                    break;
                case "right":
                    parisCol++;
                    break;
            }
            if (parisRow < 0) {
                energy--;
                parisRow++;
            } else if (parisCol < 0) {
                energy--;
                parisCol++;
            } else if (parisRow >= matrix.length) {
                energy--;
                parisRow--;
            } else if (parisCol >= matrix.length) {
                energy--;
                parisCol--;
            } else {
                energy--;
                if (matrix[parisRow][parisCol] == 'H') {
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                    matrix[parisRow][parisCol] = '-';
                    break;
                }
                if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        break;
                    }
                }
                if (energy <= 0) {
                    matrix[parisRow][parisCol] = 'X';
                    break;
                }
            }
        }
        if (energy <= 0) {
            System.out.printf("Paris died at %d;%d.", parisRow, parisCol);
            System.out.println();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
