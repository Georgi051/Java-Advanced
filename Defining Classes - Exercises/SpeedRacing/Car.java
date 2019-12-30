package DefiningClassesExercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double costFuelKm;
    private int distanceTraveled;

    public Car(String model,double fuelAmount,double costFuelKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costFuelKm = costFuelKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }


    public double getFuelAmount() {
        return fuelAmount;
    }


    public double getCostFuelKm() {
        return costFuelKm;
    }

    public boolean isValidToDrive(int kmToDrive){
        double totalDistanced = getCostFuelKm() * kmToDrive;
        if (getFuelAmount() >= totalDistanced){
            this.fuelAmount -= totalDistanced;
            this.distanceTraveled += kmToDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.getModel(),this.getFuelAmount(),this.distanceTraveled);
    }
}
