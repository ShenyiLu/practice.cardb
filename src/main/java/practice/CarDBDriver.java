package practice;


import practice.carHelper.CarDBBuilder;

/**
 * Driver class for the car database.
 *
 */
public class CarDBDriver{

	/**
	 * Main logic
	 * 
	 * Expected usage:
	 * 	java practice.CarDBDriver -in <relative path to cars.csv> -out <output file name>
	 * 
	 * Example:
	 *  java practice.CarDBDriver -in cars.csv -out actual.txt
	 * 	
	 * 
	 * @param args
	 */
	public static void main(String[] args){

		//Suggested logic:
		
		/*
		 * 1. Build a CarList object from the file specified by the second command argument.
		 * 2. Output "All Cars:" followed by a newline.
		 * 3. Output the result of calling toString on the CarList.
		 * 4. Output "Green Cars - Fuel Type:" followed by a newline.
		 * 5. Output the result of calling toStringGreenCars on the CarList.
		 * 6. Output "Average MPG All:" followed by the result of calling avgMpg on the CarList 
		 * 	   followed by a newline. The result should be displayed with exactly two digits 
		 *     after the decimal point.
		 * 7. Output "Average MPG Subaru:" followed by the result of calling avgMpgByPartialModel("SUBARU") 
		 *     on the CarList followed by a newline. The result should be displayed with exactly two digits 
		 *     after the decimal point.
		 * 8. Output "Average MPG Toyota:" followed by the result of calling avgMpgByPartialModel("TOYOTA") 
		 *     on the CarList followed by a newline. The result should be displayed with exactly two digits 
		 *     after the decimal point.
		 * 9. Output "Average MPG Ferrari:" followed by the result of calling avgMpgByPartialModel("FERRARI") 
		 *     on the CarList followed by a newline. The result should be displayed with exactly two digits 
		 *     after the decimal point.
		 * 10. Output "Vehicle Classes with 4-Cylinder Cars:" followed by a newline followed by the result of 
		 *     calling findClassesByCylinders(4) on the CarList. For each item in the list returned, output a 
		 *     tab followed by the item followed by a newline.
		 * 11. Output "Vehicle Classes with 6-Cylinder Cars:" followed by a newline followed by the result of 
		 *     calling findClassesByCylinders(6) on the CarList. For each item in the list returned, output a 
		 *     tab followed by the item followed by a newline.
		 * 12. Output "Small SUVs with MPG > 22:" followed by a newline followed by the result of calling 
		 *     findModelsByClassAndMpg("small SUV", 22) on the CarList. For each item in the list returned, 
		 *     output a tab followed by the item followed by a newline.
		 * 13. Output "Small Cars with MPG > 35:" followed by a newline followed by the result of calling 
		 *     findModelsByClassAndMpg("small car", 35) on the CarList. For each item in the list returned, 
		 *     output a tab followed by the item followed by a newline.
		 */
//		String[] order = "-in carscopy.csv -out actual.txt".split(" ");
		CarDBBuilder builder = new CarDBBuilder(args);
//		CarDBBuilder builder = new CarDBBuilder(order);
	}

}
