package DefiningClassesExercise.CatLady;

public class Siamese {
    private String name;
    private double decibelsOfMeows;

    public Siamese(String name, double specificCatThings) {
        this.name = name;
        this.decibelsOfMeows = specificCatThings;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", this.name, this.decibelsOfMeows);
    }
}
