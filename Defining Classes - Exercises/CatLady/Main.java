package DefiningClassesExercise.CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cymric> cymricMap = new HashMap<>();
        Map<String, Siamese> siameseMap = new HashMap<>();
        Map<String, StreetExtraordinaire> streetCatMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] catData = input.split("\\s+");
            String typeCat = catData[0];
            String name = catData[1];
            double specificCatThings = Double.parseDouble(catData[2]);

            if (typeCat.equals("StreetExtraordinaire")) {
                StreetExtraordinaire streetCats = new StreetExtraordinaire(name, specificCatThings);
                streetCatMap.put(name, streetCats);
            } else if (typeCat.equals("Siamese")) {
                Siamese siamese = new Siamese(name, specificCatThings);
                siameseMap.put(name, siamese);
            } else {
                Cymric cymric = new Cymric(name, specificCatThings);
                cymricMap.put(name, cymric);
            }
            input = scanner.nextLine();
        }
        String chosenCat = scanner.nextLine();

        if (cymricMap.containsKey(chosenCat)) {
            System.out.println(cymricMap.get(chosenCat).toString());
        } else if (streetCatMap.containsKey(chosenCat)) {
            System.out.println(streetCatMap.get(chosenCat).toString());
        } else {
            System.out.println(siameseMap.get(chosenCat).toString());
        }
    }
}
