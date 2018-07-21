package practice;

public class CarList {
    private Car[] carArray;
    private int size;

    public CarList(){
        carArray = new Car[10];
        size = 0;
    }

    /**
     * Takes as input a Car and inserts it into the array in sorted order.
     * Will use insertion sort.
     */
    public void addCar(Car car) {
        //Takes as input a Car and inserts it into the array in sorted order.
        // If two Car objects are equal according to compareTo they will be sorted in the list
        // in the reverse order in which they appear in the original data file.
        if (size == carArray.length){
            resize();
        }
        if (size <= 10){
            linearInsertion();
            size++;
        } else {
            binaryInsertion();
            size++;
        }
    }

    /**
     * Returns a String representation of the entire database.
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < carArray.length; i++) {
            StringBuffer temp = new StringBuffer();
            Car tempCar = carArray[i];
            temp.append("Model: " + tempCar.getModel());
            temp.append(" Class: " + tempCar.getVehicleClass());
            temp.append(" Pollution Score: " + tempCar.getPollutionScore());
            if (carArray[i] instanceof GreenCar) {
                buffer.append(temp.toString() + " Fuel Type: " + ((GreenCar) tempCar).getFuelType() + "\n");
            } else {
                buffer.append(temp.toString() + " MPG: " + ((GasCar) tempCar).getMpg() + " Cylinders: "
                        + ((GasCar) tempCar).getNumberCylinders() + "\n");
            }

        }
        return buffer.toString();
    }

    /**
     * Returns a String representation of the GreenCar objects in the list
     * @return
     */
    public String toStringGreenCars() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < carArray.length; i++) {
            if (!(carArray[i] instanceof GreenCar)) {
                continue;
            }
            GreenCar tempCar = (GreenCar) carArray[i];
            buffer.append("Model: " + tempCar.getModel() + " Fuel Type: " + tempCar.getFuelType());
        }
        return buffer.toString();
    }

    /**
     *  Returns the average MPG across all GasCar objects.
     * @return
     */
    public double avgMpg() {
        double totalMpg = 0;
        int count = 0;
        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i] instanceof GasCar) {
                GasCar tempCar = (GasCar) carArray[i];
                totalMpg += (double) tempCar.getMpg();
                count++;
            }
        }
        return totalMpg / count;
    }

    /**
     * Takes as input a String with a partial model (for example, "Subaru")
     * and returns the average MPG for all cars with a model containing the
     * partial model query String.
     * @param model
     * @return
     */
    // does avgMpg contain GreenCar?
    public double avgMpgByPartialModel(String model){
        double totalMpg = 0;
        int count = 0;
        for (int i = 0; i < carArray.length; i++) {
            // all models in CSV are upper letter, seems no need to parse
            if ((carArray[i] instanceof GasCar) && (carArray[i].getModel().contains(model))) {
                GasCar tempCar = (GasCar) carArray[i];
                totalMpg += (double) tempCar.getMpg();
                count++;
            }
        }
        return totalMpg / count;
    }

    /**
     * Takes as input an int specifying number of cylinders and returns a String[]
     * containing the vehicle classes with models that have the specified number
     * of cylinders.
     * @param cylinderCount
     * @return
     */
    public String[] findClassesByCylinders(int cylinderCount){
        return null;
    }

    /**
     * Takes as input a target vehicle class and a minimum MPG and returns a String[]
     * containing the models of all vehicles of the specified class that have at
     * least the specified combined MPG.
     * @param vehicleClass
     * @param minMpg
     * @return
     */
    public String[] findModelsByClassAndMpg(String vehicleClass, int minMpg){
        return null;
    }

    /**
     * when carArray is full, call this method to resize it.
     */
    private void resize(){
        Car[] newArray = new Car[2 * carArray.length];
        for (int i = 0; i < carArray.length; i++){
            newArray[i] = carArray[i];
        }
        carArray = newArray;
    }

    /**
     * use linear search to find insertion place in small size of array
     */
    private void linearInsertion(){

    }

    /**
     * use binary search to find insertion place in large size of array
     */
    private void binaryInsertion(){

    }
}
