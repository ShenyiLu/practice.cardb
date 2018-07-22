package practice;

import java.util.Arrays;

public class CarList {
    private Car[] carArray;
    private int endIndex;

    public CarList(){
        carArray = new Car[10];
        endIndex = -1;
    }

    /**
     * Takes as input a Car and inserts it into the array in sorted order.
     * Will use insertion sort.
     */
    public void addCar(Car car) {
        //Takes as input a Car and inserts it into the array in sorted order.
        // If two Car objects are equal according to compareTo they will be sorted in the list
        // in the reverse order in which they appear in the original data file.

        if (endIndex <= 10){
            linearInsertion(0, endIndex, car);
            endIndex++;
        } else {
            binaryInsertion(0, endIndex, car);
            endIndex++;
        }

        System.out.println("Current Car List");
        for (int i = 0; i <= endIndex; i++) {
            System.out.println(carArray[i].getModel());
        }

        if (endIndex == carArray.length){
            resize();
        }
    }

    /**
     * Returns a String representation of the entire database.
     * @return
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < endIndex; i++) {
            StringBuffer temp = new StringBuffer();
            Car tempCar = carArray[i];
            temp.append("Model: " + tempCar.getModel());
            temp.append(" Class: " + tempCar.getVehicleClass());
            temp.append(" Pollution Score: " + tempCar.getPollutionScore());

            String partialResult;
            if (carArray[i] instanceof GreenCar) {
                partialResult = temp.toString() + " Fuel Type: " + ((GreenCar) tempCar).getFuelType() + "\n";
                buffer.append(partialResult);

            } else {
                partialResult = temp.toString() + " MPG: " + ((GasCar) tempCar).getMpg() + " Cylinders: "
                        + ((GasCar) tempCar).getNumberCylinders() + "\n";
                buffer.append(partialResult);
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
        for (int i = 0; i < endIndex; i++) {
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
        for (int i = 0; i < endIndex; i++) {
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
    public double avgMpgByPartialModel(String model) {
        double totalMpg = 0;
        int count = 0;
        for (int i = 0; i < endIndex; i++) {
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
    public String[] findClassesByCylinders(int cylinderCount) {
        String[] result = new String[10];
        int stringEndIndex = -1;
        for (int i = 0; i < endIndex; i++) {
            if (carArray[i] instanceof GasCar && ((GasCar) carArray[i]).getNumberCylinders() == cylinderCount) {
                String model = ((GasCar) carArray[i]).getModel();
                if (stringEndIndex == -1) {
                    stringEndIndex++;
                    result[stringEndIndex] = model;
                    continue;
                }
                // check duplicate
                Boolean containModel = false;
                for (int j = 0; j <= stringEndIndex; j++) {
                    if (model.equals(result[j])) {
                        containModel = true;
                    }
                }
                if (!containModel) {
                    stringEndIndex++;
                    result[stringEndIndex] = model;
                }
                // resize if result array is full
                if (stringEndIndex == result.length - 1) {
                    result = resizeString(result);
                }
            }
        }

        if (stringEndIndex == -1) {
            return null;
        } else {
            return cropString(result, stringEndIndex);
        }
    }

    /**
     * Takes as input a target vehicle class and a minimum MPG and returns a String[]
     * containing the models of all vehicles of the specified class that have at
     * least the specified combined MPG.
     * @param vehicleClass
     * @param minMpg
     * @return
     */
    public String[] findModelsByClassAndMpg(String vehicleClass, int minMpg) {
        String[] result = new String[10];
        int StringEndIndex = -1;
        for (int i = 0; i < endIndex; i++) {
            if (carArray[i] instanceof GasCar && ((GasCar) carArray[i]).getVehicleClass().equals(vehicleClass)
                    && ((GasCar) carArray[i]).getMpg() > minMpg) {
                String model = ((GasCar) carArray[i]).getModel();
                StringEndIndex++;
                result[StringEndIndex] = model;
                // resize if result array is full
                if (StringEndIndex == result.length - 1) {
                    result = resizeString(result);
                }
            }
        }

        if (StringEndIndex == -1) {
            return null;
        } else {
            return cropString(result, StringEndIndex);
        }
    }

    /**
     * when carArray is full, call this method to resize it.
     */
    private void resize() {
        Car[] newArray = new Car[2 * carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            newArray[i] = carArray[i];
        }
        carArray = newArray;
    }

    /**
     * when String[] in findModels is full, call this method to resize it.
     */
    private String[] resizeString(String[] input) {
        String[] output = new String[input.length * 2];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
        return output;
    }

    /**
     * when findModels should return result, call this method to crop it and sort the result.
     */
    private String[] cropString(String[] input, int endIndex) {
        String[] output = new String[endIndex + 1];
        for (int i = 0; i <= endIndex; i++) {
            output[i] = input[i];
        }
        Arrays.sort(output);
        return output;
    }

    /**
     * use linear search to find insertion place in small array
     */
    private void linearInsertion(int start, int end, Car car) {
        if (endIndex == -1) {
            carArray[0] = car;
            return;
        }

        // this is a special case to handle ACURA ILX, which caused a special problem
        // didn't solve problem, will reconsider main logic
        if (endIndex == 0) {
            if (car.compare(carArray[start]) > 0) {
                carArray[start + 1] = car;
            } else {
                carArray[start + 1] = carArray[start];
                carArray[start] = car;
            }
            return;
        }

        int insert = start;
        while (insert < end && car.compare(carArray[insert]) > 0){
            insert++;
        }
        for (int i = endIndex; i > insert; i--) {
            carArray[i] = carArray[i - 1];
        }
        carArray[insert] = car;
    }

    /**
     * use hybrid binary search to find insertion place in large array
     */
    private void binaryInsertion(int start, int end, Car car) {
        if ((end - start) <= 10) {
            linearInsertion(start, end, car);
            return;
        }

        int mid = (start + end) / 2;
        // check this later
        if (car.compare(carArray[mid]) < 0) {
            binaryInsertion(start, mid, car);
        } else if (car.compare(carArray[mid]) > 0) {
            binaryInsertion(mid, end, car);
        } else {
            while (car.compare(carArray[mid]) == 0 && mid >= 0) {
                mid--;
            }
            mid++;
            // to make sure car will be inserted in reverse order, and keep in range of array index
            // mid should be at least 0

            for (int i = endIndex; i > mid; i--) {
                carArray[i] = carArray[i - 1];
            }
            carArray[mid] = car;
            return;
        }
    }
}
