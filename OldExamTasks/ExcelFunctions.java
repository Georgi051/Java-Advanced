package OldExamTasks;

import java.util.Scanner;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] table = new String[n][];

        for (int r = 0; r < n; r++) {
            table[r] = scanner.nextLine().split(", ");
        }
        String[] inputData = scanner.nextLine().split(" ");

        resultMatrix(inputData, table);
    }

    private static void resultMatrix(String[] command, String[][] table) {
        String header = command[1];
        int index =  findColumnIndex(table[0], header);
        switch (command[0]) {
            case "hide":
                for (int r = 0; r < table.length; r++) {
                    for (int c = 0; c < table[r].length; c++) {
                        if (c == index) {
                            continue;
                        }
                        System.out.print(table[r][c]);
                        if (c != table[r].length - 1) {
                            System.out.print(" | ");
                        }
                    }
                    System.out.println();
                }
                break;
            case "sort":

                for (int i = 0; i < table.length; i++) {
                    for (int r = 1; r < table.length - 1; r++) {
                        if (table[r][index].compareTo(table[r + 1][index]) > 0) {
                            String[] temp = table[r];
                            table[r] = table[r + 1];
                            table[r + 1] = temp;
                        }
                    }
                }
                for (int r = 0; r < table.length; r++) {
                    for (int c = 0; c < table[r].length; c++) {
                        System.out.print(table[r][c]);
                        if (c != table[r].length - 1) {
                            System.out.print(" | ");
                        }
                    }
                    System.out.println();
                }
                break;
            case "filter":
                String value = command[2];
                System.out.println(String.join(" | ",table[0]));
                for (int r = 1; r < table.length; r++) {
                    if (table[r][index].equals(value)){
                        System.out.println(String.join(" | ",table[r]));
                    }
                }
                break;
        }
    }

    private static int findColumnIndex(String[] matrix, String header) {
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].equals(header)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
