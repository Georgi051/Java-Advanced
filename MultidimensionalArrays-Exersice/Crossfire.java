package MultidimensionalArrays.exracise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColsData = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(rowsAndColsData[0]);
        int cols = Integer.parseInt(rowsAndColsData[1]);

        ArrayList<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix,rows,cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            String[] data = command.split("\\s+");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int r = row - radius; r <= row + radius; r++) {
                if (indexCheck(r,col,matrix) && r != row){
                    matrix.get(r).remove(col);
                }
            }
            for (int c = col + radius; c >= col - radius; c--) {
                if (indexCheck(row, c, matrix)){
                    matrix.get(row).remove(c);
                }
            }
            matrix.removeIf(List::isEmpty);
            command = scanner.nextLine();
        }

        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    private static boolean indexCheck(int row, int col, ArrayList<List<Integer>> matrix) {
            return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(ArrayList<List<Integer>> matrix, int rows, int cols) {
        int startNumFill = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(startNumFill++);
            }
        }
    }
}
