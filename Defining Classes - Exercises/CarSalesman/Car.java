package DefiningClassesExercise.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;
    private static String nothing = "n/a";


    public Car(String model,Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = nothing;
        this.color = nothing;
    }

    public Car(String model,Engine engine,String colorOrWeight){
        this(model,engine);
        if (Character.isAlphabetic(colorOrWeight.charAt(0))){
            this.weight = nothing;
            this.color = colorOrWeight;
        }else {
            this.weight = colorOrWeight;
            this.color = nothing;
        }
    }

    public Car(String model,Engine engine,String weight,String color){
        this(model, engine, color);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return
                this.model + ":\n"
                + this.engine.toString() +"\n"
                + "Weight: " + this.weight +"\n"
                + "Color: " + this.color;
    }
}
