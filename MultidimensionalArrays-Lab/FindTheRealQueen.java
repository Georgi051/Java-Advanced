package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;
        char[][] board = new char[size][size];

        for (int row = 0; row < board.length; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int col = 0; col < data.length; col++) {
                board[row][col] = data[col].charAt(0);
            }
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c]== 'q'){
                    boolean isColIsValid = colCheck(board,c);
                    boolean isRowIsValid = rowCheck(board,r);
                    boolean isUpLeftMainDiagonalValid
                            = upLeftMainDiagonalCheck(board,r,c);
                    boolean isDownRightMainDiagonalValid
                            = downRightMainDiganalCheck(board,r,c);
                    boolean isUpRightSecondDiagonalValid
                            = isUpRightSecondDiagonalValid(board,r,c);
                    boolean isDownLeftSecondDiagonalValid
                            = isDownLeftSecondDiagonalValid(board,r,c);

                    if (isColIsValid && isRowIsValid && isUpLeftMainDiagonalValid && isDownLeftSecondDiagonalValid
                    && isDownRightMainDiagonalValid && isUpRightSecondDiagonalValid){
                        System.out.println(r + " " + c);
                    }
                }
            }
        }
    }

    private static boolean isDownLeftSecondDiagonalValid(char[][] board, int row, int col) {
        row++;
        col--;
        while (row < 8 && col >= 0){
            if (board[row++][col--] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean isUpRightSecondDiagonalValid(char[][] board, int row, int col) {
        row--;
        col++;
        while (row >= 0 && col < 8){
            if (board[row--][col++] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean downRightMainDiganalCheck(char[][] board, int row, int col) {
        row++;
        col++;
        while (row < 8 && col < 8){
            if (board[row++][col++] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean upLeftMainDiagonalCheck(char[][] board, int row, int col) {
        row--;
        col--;
        while (row >= 0 && col >= 0){
            if (board[row--][col--] == 'q'){
                return false;
            }
        }
        return true;
    }

    private static boolean rowCheck(char[][] board, int row) {
        int queenCount = 0;
        for (int i = 0; i < board.length; i++) {
            char symbol = board[row][i];
            if (symbol == 'q'){
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean colCheck(char[][] board,int col) {
        int queenCount = 0;

        for (int i = 0; i < board.length; i++) {
            char symbol = board[i][col];
             if (symbol == 'q'){
                 queenCount++;
             }
        }
        return queenCount == 1;
    }
}
