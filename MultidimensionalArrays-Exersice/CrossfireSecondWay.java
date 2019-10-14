package MultidimensionalArrays.exracise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CrossfireSecondWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixData = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixData[0]);
        int cols = Integer.parseInt(matrixData[1]);

        ArrayList<List<Integer>> matrix = new ArrayList<>();
        readMatrixData(matrix, rows, cols);
        String command = scanner.nextLine();
        while (!"Nuke it from orbit".equals(command)) {
            String[] data = command.split(" ");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInRange(r, col, matrix)) {
                    matrix.get(r).set(col, 0);
                }
            }
            for (int c = col - radius; c <= col + radius; c++) {
                if (isInRange(row, c, matrix)) {
                    matrix.get(row).set(c, 0);
                }
            }
            for (int r = 0; r < matrix.size(); r++) {
               //FirstWay:  matrix.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});
                matrix.set(r,matrix.get(r).stream().filter(element -> element != 0)
                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(r).size() == 0) {
                    matrix.remove(r--);
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<List<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }

    }
    private static boolean isInRange(int row, int col, ArrayList<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void readMatrixData(ArrayList<List<Integer>> matrix, int rows, int cols) {
        int startNum = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(startNum++);
            }
        }
    }
}
