package OldExamTasks;

import java.util.Scanner;

public class HelenAbduction {
    private static  int energy;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][];

        int pRow = 0;
        int pCow = 0;

        for (int i = 0; i < field.length; i++) {
            String line = scanner.nextLine();
            if (line.contains("P")){
                pRow = i;
                pCow = line.indexOf('P');
            }
            field[i] = line.toCharArray();
        }

        boolean isAbdicated = false;
        while (!isAbdicated && energy-- > 0){
            String[] input = scanner.nextLine().split("\\s+");
            String direction = input[0];
            int sRow = Integer.parseInt(input[1]);
            int sCol = Integer.parseInt(input[2]);
            field[sRow][sCol] = 'S';

            field[pRow][pCow] = '-';
            if (direction.equals("up") && canMove(pRow - 1,pCow,field)){
                pRow--;
                isAbdicated = checkParisPosition(pRow,pCow,field);
            }else if (direction.equals("down")&& canMove(pRow + 1,pCow,field)){
                pRow++;
                isAbdicated = checkParisPosition(pRow,pCow,field);
            }else if (direction.equals("left")&& canMove(pRow,pCow - 1,field)){
                pCow--;
                isAbdicated = checkParisPosition(pRow,pCow,field);
            }else if (direction.equals("right")&& canMove(pRow,pCow + 1,field)){
                pCow++;
                isAbdicated = checkParisPosition(pRow,pCow,field);
            }
            field[pRow][pCow] = 'P';

            if (isAbdicated){
                field[pRow][pCow] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",energy);
            }
        }
        if (energy <= 0){
            field[pRow][pCow] = 'X';
            System.out.printf("Paris died at %d;%d.%n",pRow,pCow);
        }
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean checkParisPosition(int pRow, int pCow, char[][] field) {
        boolean isAbdicated = false;
        if (field[pRow][pCow] == 'S'){
            energy -= 2;
        }else if (field[pRow][pCow] == 'H'){
            isAbdicated = true;
        }
        return isAbdicated;
    }

    private static boolean canMove(int pRow, int pCow, char[][] field) {
        return pRow >= 0 && pRow < field.length && pCow >= 0 && pCow < field[pRow].length;
    }
}
