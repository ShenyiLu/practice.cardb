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

    public int compare(Car car2) {
        if (getPollutionScore() == car2.getPollutionScore()) {
            return getModel().compareTo(car2.getModel());
        }
        return getPollutionScore().compareTo(car2.getPollutionScore());
    }
}
