package practice;

public class GasCar extends Car {
    private int numberCylinders;
    private int mpg;


    public GasCar(String model, String vehicleClass, int pollutionScore, int numberCylinders, int mpg) {
        super(model, vehicleClass, pollutionScore);
        this.numberCylinders = numberCylinders;
        this.mpg = mpg;
    }

    public int getNumberCylinders(){
        return numberCylinders;
    }

    public int getMpg() {
        return mpg;
    }
}
