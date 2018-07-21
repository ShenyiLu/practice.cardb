package practice;

public class Car {
    private String model;
    private String vehicleClass;
    private int pollutionScore;

    public Car(String model, String vehicleClass, int pollutionScore) {
        this.model = model;
        this.vehicleClass = vehicleClass;
        this.pollutionScore = pollutionScore;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public Integer getPollutionScore() {
        return pollutionScore;
    }

    public String getCarType() {
        return "Car";
    }

    public int compare(Car car1, Car car2) {
        if (car1.getPollutionScore() == car2.getPollutionScore()) {
            return car1.getModel().compareTo(car2.getModel());
        }
        return car1.getPollutionScore().compareTo(car2.getPollutionScore());
    }
}
