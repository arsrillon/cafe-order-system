package Main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        Cafe cafe = new Cafe();

        // Creating cafe
        while(true) {
            System.out.println("1. Add order\n" + "2. Show all orders\n" + "3. Find order by customer name\n" + "4. Delete customer orders\n" + "5. Exit\n"); // Cafe menu

            int input = getIntInput(scan, "Choose: ");

            if(!isPositive(input, "Choose")) break;

            // Adding order
            if(input == 1) {
                System.out.println("1 - Food\n" + "2 - Drink\n");

                int choose = getIntInput(scan, "Choose: ");

                if(!isPositive(choose, "Choose")) break;

                // Creating a food
                if(choose == 1) {
                    System.out.print("Enter customer name: ");
                    String customerName = scan.nextLine();

                    System.out.print("Enter dish name: ");
                    String dishName = scan.nextLine();

                    double price = getDoubleInput(scan, "Enter dish price: ");

                    if(!validatePositive(price, "Price")) break;

                    int calories = getIntInput(scan, "Enter dish calories: ");

                    if(!validatePositive(calories, "Calories")) break;

                    Food food = new Food(customerName, dishName, price, calories);

                    cafe.addOrder(food);

                    System.out.println("\nFood created is successfully!\n");
                }

                // Creating a drink
                if(choose == 2) {
                    System.out.print("Enter customer name: ");
                    String customerName = scan.nextLine();

                    System.out.print("Enter drink name: ");
                    String dishName = scan.nextLine();

                    double price = getDoubleInput(scan, "Enter drink price: ");

                    if(!validatePositive(price, "Price")) break;

                    int volume = getIntInput(scan, "Enter drink volume: ");

                    if(!validatePositive(volume, "Volume")) break;

                    Drink drink = new Drink(customerName, dishName, price, volume);

                    cafe.addOrder(drink);

                    System.out.println("\nDrink created is successfully!\n");
                }
            }

            // Show all orders
            if(input == 2) {
                cafe.showAllOrders();
            }

            // Find order by customer name
            if(input == 3) {
                System.out.print("\nEnter customer name: ");
                String customerName = scan.nextLine();
                cafe.findOrder(customerName);
                System.out.println();
            }

            // Delete customer orders
            if(input == 4) {
                System.out.print("\nEnter customer name: ");
                String customerName = scan.nextLine();
                cafe.removeOrder(customerName);
                System.out.println();
            }

            // Exit
            if (input == 5) {
                System.out.println("\nOkay, goodbye!");
                break;
            }
        }

    }

    // Method to check the presence of numbers for int
    public static int getIntInput(Scanner scan, String prompt) {
        while(true) {
            System.out.print(prompt);
            if(scan.hasNextInt()) {
                int value = scan.nextInt();
                scan.nextLine();
                return value;
            } else {
                System.out.println("This is not a number!");
                scan.nextLine();
            }
        }
    }

    // Method to check the presence of numbers for double
    public static double getDoubleInput(Scanner scan, String prompt) {
        while(true) {
            System.out.print(prompt);
            if(scan.hasNextDouble()) {
                double value = scan.nextDouble();
                scan.nextLine();
                return value;
            } else {
                System.out.println("This is not a double!");
                scan.nextLine();
            }
        }
    }

    // Method for validating numbers for int <= 0
    public static boolean isPositive(int value, String fieldName) {
        if(value <= 0) {
            System.out.println("\n" + fieldName + " is incorrect!\n");
            return false;
        }
        return true;
    }

    // Method for validating numbers for double < 0
    public static boolean validatePositive(double value, String fieldName) {
        if(value < 0) {
            System.out.println("\n" + fieldName + " is incorrect!\n");
            return false;
        }
        return true;
    }

    // Method for validating numbers for int < 0
    public static boolean validatePositive(int value, String fieldName) {
        if(value < 0) {
            System.out.println("\n" + fieldName + " is incorrect!\n");
            return false;
        }
        return true;
    }
}