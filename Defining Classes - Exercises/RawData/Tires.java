package DefiningClassesExercise.RawData;

import java.util.List;

public class Tires {
    private List<Double> tiers;

    public Tires(List<Double> tiers) {
        this.tiers = tiers;
    }

    public List<Double>  getTiers() {
        return tiers;
    }
}
