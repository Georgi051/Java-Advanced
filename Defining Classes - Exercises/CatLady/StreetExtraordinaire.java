package DefiningClassesExercise.CatLady;

public class StreetExtraordinaire {
    private String name;
    private double earSize;

    public StreetExtraordinaire(String name, double specificCatThings) {
        this.name = name;
        this.earSize = specificCatThings;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f",this.name,this.earSize);
    }
}
