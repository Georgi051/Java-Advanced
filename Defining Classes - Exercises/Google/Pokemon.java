package DefiningClassesExercise.Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String pokemonName, String type) {
        this.name = pokemonName;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name + " " + this.type;
    }
}
