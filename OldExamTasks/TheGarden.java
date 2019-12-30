package OldExamTasks;

import java.util.*;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowSize = Integer.parseInt(scanner.nextLine());
        String[][] garden = new String[rowSize][];

        for (int row = 0; row < garden.length; row++) {
            garden[row] = scanner.nextLine().split(" ");
        }
        Map<Character, Integer> harvestMap = new TreeMap<>();
        harvestMap.put('L', 0);
        harvestMap.put('P', 0);
        harvestMap.put('C', 0);
        int harmedCount = 0;
        String input = scanner.nextLine();
        while (!"End of Harvest".equals(input)) {
            String[] data = input.split("\\s+");

            if (data[0].equals("Harvest")) {
                int productRow = Integer.parseInt(data[1]);
                int productCol = Integer.parseInt(data[2]);
                if (isInRange(productRow, productCol, garden) && garden[productRow][productCol].equals("L")) {
                    harvestMap.put('L', harvestMap.get('L') + 1);
                    garden[productRow][productCol] = " ";
                }
            } else if (data[0].equals("Mole")) {
                int moleR = Integer.parseInt(data[1]);
                int moleC = Integer.parseInt(data[2]);
                String direction = data[3];
                switch (direction){
                    case "up":

                        break;
                    case "down":

                        break;
                    case "left":

                        break;
                    case "right":

                        break;
                }
                if (isInRange(moleR,moleC,garden)){


                }
            }
            input = scanner.nextLine();
        }




    }

    private static boolean isInRange(int row, int col, String[][] garden) {
        return row >= 0 && row < garden.length && col >= 0 && col < garden[row].length;
    }
}
