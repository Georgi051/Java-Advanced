package DefiningClassesExercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String trainerName;
    private Map<String, List<Pokemon>> pokemons;
    private int numberOfBadges;


    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.pokemons = new HashMap<>();
        this.numberOfBadges = 0;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        pokemons.get(pokemon.getElement()).add(pokemon);
    }


    public boolean checkElement(String element) {
        for (List<Pokemon> pokemonList : pokemons.values()) {
            for (Pokemon pokemon : pokemonList) {
                if (pokemon.getElement().equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addBadge(int badge) {
        this.numberOfBadges += badge;
    }

    public Integer getNumberOfBadges() {
        return numberOfBadges;
    }

    public void checkPokemonHealth() {
        for (List<Pokemon> pokemonList : pokemons.values()) {
            pokemonList.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public int pokemonCount() {
        int count = 0;
        for (List<Pokemon> value : pokemons.values()) {
            count += value.size();
        }
        return count;
    }

    public void damagePokemon(int damage) {
        for (List<Pokemon> pokemonList : pokemons.values()) {
            for (Pokemon pokemon : pokemonList) {
                pokemon.damagePokemon(damage);
            }
        }
        checkPokemonHealth();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.trainerName, this.numberOfBadges, pokemonCount());
    }
}
