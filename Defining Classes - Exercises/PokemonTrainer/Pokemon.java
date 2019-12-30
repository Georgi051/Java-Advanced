package DefiningClassesExercise.PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String element, int pokemonHealth) {
        this.name = pokemonName;
        this.element = element;
        this.health = pokemonHealth;
    }

    public String getElement() {
        return this.element;
    }

    public void damagePokemon(int damage) {
        this.health -= damage;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return health;
    }
}
