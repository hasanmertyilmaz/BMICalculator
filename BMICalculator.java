import java.util.InputMismatchException;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {

            double height = 0;
            double weight = 0;

            // Input validation for height
            while (true) {
                try {
                    System.out.println("Please Enter Your Height in meters: ");
                    height = scanner.nextDouble();
                    if (height <= 0) {
                        System.out.println("Height Must Be Greater Than 0, Please Try Again. ");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for height");
                    scanner.next();
                }
            }

            // Input validation for weight
            while (true) {
                try {
                    System.out.println("Please Enter Your Weight in Kg: ");
                    weight = scanner.nextDouble();
                    if (weight <= 0) {
                        System.out.println("Weight Must Be Greater Than 0, Please Try Again. ");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please Enter a Valid Number For Weight. ");
                    scanner.next();
                }
            }

            // Calculate BMI
            double bmi = calculateBMI(height, weight);
            System.out.println("Your Body Mass Index (BMI) is: " + bmi);

            // Determine and display the BMI category
            String category = determineBMICategory(bmi);
            System.out.println("Your category is: " + category);

            // Ask if the user wants to calculate again
            System.out.println("Would you like to calculate again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                continueProgram = false;
            }
        }

        System.out.println("Program terminated. GoodBye!");
        scanner.close();
    }
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }
    public static String determineBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal Weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else if (bmi < 35) {
            return "Obese";
        } else {
            return "Severely obese";
        }
    }
}