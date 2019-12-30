package DefiningClassesExercise.CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;
    private static String nothing = "n/a";


    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = nothing;
        this.efficiency = nothing;
    }

    public Engine(String model, String power, String engineData) {
        this(model, power);
        if (Character.isLetter(engineData.charAt(0))){
            this.displacement = nothing;
            this.efficiency = engineData;
        }else {
            this.displacement = engineData;
            this.efficiency = nothing;
        }
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return
                this.model +":\n"
                + "Power: " + this.power +"\n"
                + "Displacement: " + this.displacement +"\n"
                + "Efficiency: " + this.efficiency;
    }
}
