package OldExamTasks.tasks;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];

        int row = 0;
        int col = 0;

        for (int i = 0; i < field.length; i++) {
            String line = scanner.nextLine();
            if (line.contains("P")){
                row = i;
                col = line.indexOf('P');
            }
            field[i] = line.toCharArray();
        }
        int isInRange = 0;
        String command = scanner.nextLine();
        while (!"end".equals(command)){
            String direction = command;

            field[row][col] = '-';
            switch (direction){
                case "up":
                    row--;
                    if (row < 0){
                        field[++row][col] = 'P';
                        deleteLastLetter(sb);
                        isInRange = 1;
                    }else {
                        getLetter(sb,field[row--][col]);
                        field[++row][col] = 'P';
                    }
                    break;
                case "down":
                    row++;
                    if (row >= field.length){
                        field[--row][col] = 'P';
                        deleteLastLetter(sb);
                        isInRange = 1;
                    }else {
                        getLetter(sb,field[row++][col]);
                        field[--row][col] = 'P';
                    }
                    break;
                case "left":
                    col--;
                    if (col < 0){
                        field[row][++col] = 'P';
                        deleteLastLetter(sb);
                        isInRange = 1;
                    }else {
                        getLetter(sb,field[row][col--]);
                        field[row][++col] = 'P';
                    }
                    break;
                case "right":
                    col++;
                    if (col >= field.length){
                        field[row][--col] = 'P';
                        isInRange = 1;
                    }else {
                        getLetter(sb,field[row][col++]);
                        field[row][--col] = 'P';
                    }
                    break;
            }
            if (isInRange > 0){
                System.out.println(sb);
                printMatrix(field);
                return;
            }
            command = scanner.nextLine();
        }
        System.out.println(sb);
        printMatrix(field);
    }

    private static void deleteLastLetter(StringBuilder sb) {
        sb.replace(0,sb.length(),sb.substring(0,sb.length()-1));
    }

    private static void getLetter(StringBuilder sb, char letter) {
        if (Character.isLetter(letter)){
            sb.append(letter);
        }
    }

    private static void printMatrix(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
