package DefiningClassesExercise.CatLady;

public class Cymric {
    private String name;
    private double furLength;


    public Cymric(String name, double specificCatThings) {
        this.name = name;
        this.furLength = specificCatThings;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f",this.name,this.furLength);
    }
}
