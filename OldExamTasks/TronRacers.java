package OldExamTasks;

import java.util.Scanner;

public class TronRacers {
    private static char[][] matrix;
    private static int fPlayerRow = 0;
    private static int fPlayerCol = 0;
    private static int sPlayerRow = 0;
    private static int sPlayerCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("f")) {
                fPlayerRow = i;
                fPlayerCol = line.indexOf('f');
            }
            if (line.contains("s")) {
                sPlayerRow = i;
                sPlayerCol = line.indexOf('s');
            }
        }
        boolean firstPlayerIsAlive = true;
        boolean secondPlayerIsAlive = true;

        while (secondPlayerIsAlive) {
            String[] directions = scanner.nextLine().split("\\s+");
            String firstD = directions[0];
            String secondD = directions[1];

            firstPlayerIsAlive = MoveDirection('f', fPlayerRow, fPlayerCol, firstD);
            if (!firstPlayerIsAlive) {
                break;
            }
            secondPlayerIsAlive = MoveDirection('s', sPlayerRow, sPlayerCol, secondD);
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean MoveDirection(char player, int row, int col, String direction) {
        int newRow = row;
        int newCol = col;

        switch (direction) {
            case "up":
                newRow = row - 1 < 0 ? matrix.length - 1 : row - 1;
                break;
            case "down":
                newRow = row + 1 >= matrix.length ? 0 : row + 1;
                break;
            case "left":
                newCol = col - 1 < 0 ? matrix[row].length - 1 : col - 1;
                break;
            case "right":
                newCol = col + 1 >= matrix[row].length ? 0 : col + 1;
                break;
        }

        if ((matrix[newRow][newCol] == 'f' && player == 's') ||
                (matrix[newRow][newCol] == 's' && player == 'f')) {
            matrix[newRow][newCol] = 'x';
            return false;
        }

        matrix[newRow][newCol] = player;
        if (player == 'f') {
            fPlayerRow = newRow;
            fPlayerCol = newCol;
        } else {
            sPlayerRow = newRow;
            sPlayerCol = newCol;
        }
        return true;
    }
}
