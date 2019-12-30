package OldExamTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] galaxy = new char[n][n];
        int shipRow = 0;
        int shipCol = 0;
        List<Integer> holesIndexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                shipRow = i;
                shipCol = line.indexOf('S');
            }
            if (line.contains("O")) {
                holesIndexes.add(i);
                holesIndexes.add(line.indexOf('O'));
            }
            galaxy[i] = line.toCharArray();
        }
        int starPower = 0;

        boolean galaxyRangeCheck = true;
        while (galaxyRangeCheck) {
            String direction = scanner.nextLine();

            if (direction.equals("up")) {
                galaxy[shipRow][shipCol] = '-';
                if (galaxyRangeCheck(galaxy, shipRow - 1, shipCol)){
                    if (galaxy[shipRow - 1][shipCol] == 'O') {
                        galaxy[shipRow - 1][shipCol] = '-';
                        shipRow = holesIndexes.get(2);
                        shipCol = holesIndexes.get(3);
                        continue;
                    }
                    if (Character.isDigit(galaxy[shipRow - 1][shipCol])) {
                        starPower += (galaxy[shipRow - 1][shipCol]) - '0';
                        galaxy[shipRow - 1][shipCol] = '-';
                    }else {
                        shipRow--;
                    }
                }else {
                    galaxyRangeCheck = false;
                }
            } else if (direction.equals("down")) {
                galaxy[shipRow][shipCol] = '-';
                if (galaxyRangeCheck(galaxy, shipRow + 1, shipCol)){
                    if (galaxy[shipRow + 1][shipCol] == 'O') {
                        galaxy[shipRow + 1][shipCol] = '-';
                        shipRow = holesIndexes.get(2);
                        shipCol = holesIndexes.get(3);
                        continue;
                    }
                    if (Character.isDigit(galaxy[shipRow + 1][shipCol])) {
                        starPower += (galaxy[shipRow + 1][shipCol]) - '0';
                        galaxy[shipRow + 1][shipCol] = '-';
                        shipRow++;
                    }else {
                        shipRow++;
                    }
                }else {
                    galaxyRangeCheck = false;
                }
            } else if (direction.equals("left")) {
                galaxy[shipRow][shipCol] = '-';
                if (galaxyRangeCheck(galaxy, shipRow, shipCol - 1)){
                    if (galaxy[shipRow][shipCol - 1] == 'O') {
                        galaxy[shipRow][shipCol - 1] = '-';
                        shipRow = holesIndexes.get(2);
                        shipCol = holesIndexes.get(3);
                        continue;
                    }
                    if (Character.isDigit(galaxy[shipRow][shipCol - 1])) {
                        starPower += (galaxy[shipRow][shipCol - 1]) - '0';
                        galaxy[shipRow][shipCol - 1] = '-';
                        shipCol--;
                    }else {
                        shipCol--;
                    }
                }else {
                    galaxyRangeCheck = false;
                }
            } else if (direction.equals("right")) {
                galaxy[shipRow][shipCol] = '-';
                if (galaxyRangeCheck(galaxy, shipRow, shipCol + 1)) {
                    if (galaxy[shipRow][shipCol + 1] == 'O') {
                        galaxy[shipRow][shipCol + 1] = '-';
                        shipRow = holesIndexes.get(2);
                        shipCol = holesIndexes.get(3);
                        continue;
                    }
                    if (Character.isDigit(galaxy[shipRow][shipCol + 1])) {
                        starPower += (galaxy[shipRow][shipCol + 1]) - '0';
                        galaxy[shipRow][shipCol + 1] = '-';
                        shipCol++;
                    }else {
                        shipCol++;
                    }
                } else {
                    galaxyRangeCheck = false;
                }
            }

            if (starPower >= 50) {
                galaxy[shipRow][shipCol] = 'S';
                break;
            }

        }
        if (starPower >= 50){
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
            System.out.printf("Star power collected: %d%n",starPower);
        }else {
            System.out.println("Bad news, the spaceship went to the void.");
            System.out.printf("Star power collected: %d%n",starPower);
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(galaxy[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean galaxyRangeCheck(char[][] galaxy, int shipRow, int shipCol) {
        return shipRow >= 0 && shipRow < galaxy.length && shipCol >= 0 && shipCol < galaxy[shipRow].length;
    }
}
