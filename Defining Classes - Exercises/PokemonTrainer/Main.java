package DefiningClassesExercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);

            trainerMap.putIfAbsent(trainerName, trainer);
            trainerMap.get(trainerName).addPokemon(pokemon);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String element = input;

            for (Trainer trainer : trainerMap.values()) {
                if (trainer.checkElement(element)) {
                    trainer.addBadge(1);
                } else {
                    trainer.damagePokemon(10);
                }
            }
            input = scanner.nextLine();
        }

        trainerMap.entrySet().stream().sorted((f, s) ->
                s.getValue().getNumberOfBadges().compareTo(f.getValue().getNumberOfBadges())
        ).forEach(p -> System.out.println(p.getValue().toString()));
    }
}
