package practice;

public class GreenCar extends Car {
    private String fuelType;

    public GreenCar(String model, String vehicleClass, int pollutionScore, String fuelType) {
        super(model, vehicleClass, pollutionScore);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getCarType() {
        return "GreenCar";
    }
}
