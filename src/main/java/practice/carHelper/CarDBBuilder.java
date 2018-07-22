package practice.carHelper;

import practice.Car;
import practice.CarList;
import practice.GasCar;
import practice.GreenCar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CarDBBuilder {

    private CarList carList;

    public CarDBBuilder(String[] args){
        carList = new CarList();
        csvReader(args[1]);
        output(args[3]);
    }

    /**
     * Scan Input file and build Carlist object
     * @param filename
     */
    private void csvReader(String filename) {
        try (FileReader f = new FileReader(filename);
             BufferedReader br = new BufferedReader(f)) {
            // first line is header
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                Car tempCar;
                if (temp[5].equals("Hydrogen") || temp[5].equals("Electricity")) {
                    tempCar = new GreenCar(temp[0], temp[10], Integer.parseInt(temp[11]), temp[5]);
                } else {
                    int mpg = 0;
                    if(temp[14].contains("/")){
                        String[] tempMpg = temp[14].split("/");
                        mpg = Integer.parseInt(tempMpg[0]);
                    } else {
                        mpg = Integer.parseInt(temp[14]);
                    }

                    tempCar = new GasCar(temp[0], temp[10], Integer.parseInt(temp[11]),
                            Integer.parseInt(temp[2]), mpg);
                }
                carList.addCar(tempCar);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return;
    }

    /**
     * Output txt file
     * @param filename
     */
    private void output(String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.println("All Cars:");
            pw.println(carList.toString());

            pw.println("Green Cars - Fuel Type:");
            pw.println(carList.toStringGreenCars());

            pw.println("Average MPG All:");
            formatDigit(carList.avgMpg(), pw);

            pw.println("Average MPG Subaru:");
            formatDigit(carList.avgMpgByPartialModel("SUBARU"), pw);

            pw.println("Average MPG Toyota:");
            formatDigit(carList.avgMpgByPartialModel("TOYOTA"), pw);

            pw.println("Average MPG Ferrari:");
            formatDigit(carList.avgMpgByPartialModel("FERRARI"), pw);

            pw.println("Vehicle Classes with 4-Cylinder Cars:");
            formatString(carList.findClassesByCylinders(4), pw);

            pw.println("Vehicle Classes with 6-Cylinder Cars:");
            formatString(carList.findClassesByCylinders(6), pw);

            pw.println("Small SUVs with MPG > 22:");
            formatString(carList.findModelsByClassAndMpg("small SUV", 22), pw);

            pw.println("Small Cars with MPG > 35:");
            formatString(carList.findModelsByClassAndMpg("small car", 35), pw);


            pw.flush();
        } catch (IOException e) {
            System.out.println("Error writing to a file: " + e);
        }
    }

    /**
     * Format output of avgMpg method
     */
    private void formatDigit(double mpg, PrintWriter pw) {
        pw.println(String.format("%.2f", mpg));
    }

    /**
     * Format output of findClasses and findModels methods
     */
    private void formatString(String[] model, PrintWriter pw) {
        System.out.println(model.length);
        for (int i = 0; i < model.length; i++) {
            pw.println("\t" + model[i]);
        }
    }
}
