package OldExamTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SpaceshipCrafting {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> liquids = Arrays.stream(bReader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> items = Arrays.stream(bReader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        TreeMap<String, Integer> materials = new TreeMap<>();

        boolean glassCheck = false; boolean aluminiumCheck = false; boolean lithiumCheck = false;
        boolean carbonFiberCheck = false;

        materials.put("Aluminium", 0);
        materials.put("Carbon fiber", 0);
        materials.put("Glass", 0);
        materials.put("Lithium", 0);

        String carbon = "Carbon fiber";
        String lithium = "Lithium";
        String aluminium = "Aluminium";
        String glass = "Glass";

        while (!liquids.isEmpty() && !items.isEmpty()) {
            int liquid = liquids.removeFirst();
            int item = items.removeLast();
            int sum = liquid + item;
            switch (sum) {
                case 100:
                    materials.put(carbon, materials.get(carbon) + 1);
                    carbonFiberCheck = true;
                    break;
                case 75:
                    materials.put(lithium, materials.get(lithium) + 1);
                    lithiumCheck = true;
                    break;
                case 50:
                    materials.put(aluminium, materials.get(aluminium) + 1);
                    aluminiumCheck = true;
                    break;
                case 25:
                    materials.put(glass, materials.get(glass) + 1);
                    glassCheck = true;
                    break;
                default:
                    items.addLast(item + 3);
            }
        }
        if (carbonFiberCheck && glassCheck && lithiumCheck && aluminiumCheck) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have " +
                    "enough materials to build the spaceship.");
        }
        if (!liquids.isEmpty()) {
            ArrayList<Integer> liquidsList = new ArrayList<>(liquids);
            System.out.print("Liquids left: ");
            printResult(liquidsList, liquidsList.size());
        } else {
            System.out.println("Liquids left: none");
        }
        if (!items.isEmpty()) {
            ArrayList<Integer> itemsList = new ArrayList<>(items);
            Collections.reverse(itemsList);
            System.out.print("Physical items left: ");
            printResult(itemsList, items.size());
        } else {
            System.out.println("Physical items left: none");
        }
        materials.entrySet().forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }

    private static void printResult(ArrayList<Integer> itemsList, int size) {
        for (int i = 0; i < itemsList.size(); i++) {
            if (i < size - 1) {
                System.out.print(itemsList.get(i) + ", ");
            } else {
                System.out.print(itemsList.get(i));
                System.out.println();
            }
        }
    }
}

