package practice;

public class CarList {
    private Car[] carArray;

    /**
     * Takes as input a Car and inserts it into the array in sorted order.
     * Will use insertion sort.
     */
    public void addCar() {
        //Takes as input a Car and inserts it into the array in sorted order.
        // If two Car objects are equal according to compareTo they will be sorted in the list
        // in the reverse order in which they appear in the original data file.
    }

    /**
     * Returns a String representation of the entire database.
     * @return
     */
    public String toString(){
        return "";
    }

    /**
     * Returns a String representation of the GreenCar objects in the list
     * @return
     */
    public String toStringGreenCars(){
        return "";
    }

    /**
     *  Returns the average MPG across all GasCar objects.
     * @return
     */
    public double avgMpg(){
        return 0;
    }

    /**
     * Takes as input a String with a partial model (for example, "Subaru")
     * and returns the average MPG for all cars with a model containing the
     * partial model query String.
     * @param model
     * @return
     */
    public double avgMpgByPartialModel(String model){
        return 0;
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

    private void resize(){

    }
}
