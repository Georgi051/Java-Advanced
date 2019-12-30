package DefiningClassesExercise.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;


    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public boolean checkEngine() {
        return engine.getPower() > 250;
    }

    public boolean isCurrentPressure(){
        for (double tier : this.tires.getTiers()) {
            if (tier < 1){
                return true;
            }
        }
        return false;
    }

    public String getCargoType(){
        return this.cargo.getType();
    }

    @Override
    public String toString() {
        return this.model;
    }
}
