/*
Title: Main
Author: Draedn Groves
Date: Mar.5th/2024
Purpose: Main class of program
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        displayMenu();
        Car.populateCarList();
        Service.populateServiceList();
    }

    // <editor-fold desc="Display Menu">
    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do { // Display menu options
            System.out.println("""
                *********************************************
                |              Draedn's Auto Shop           |
                *********************************************
                Please select one of the following options:      
                1.	Populate Car List
                2.	Populate Service List
                3.	Show Car Details
                4.	Show Service Details
                5.	Add Maintenance
                6.	Show Maintenance by Invoice
                7.	Show All Maintenance
                8.	Get Help!
                9.	Exit program
                -----------------------
                Enter your choice below.""");

            // Error handling
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter an option from the menu please. ");
                sc.next();
            }

            // Set choice = the next int it finds.
            choice = sc.nextInt();

            // Perform service based on selection
            switch (choice) {
                case 1: // Populate Car List
                    System.out.println("You chose option 1. Let's populate the car list!");
                    Car.populateCarList();
                    Tools.pauseProgram();
                    break;
                case 2: // Populate Service List
                    System.out.println("You chose option 2. Let's populate the service list!");
                    Service.populateServiceList();
                    Tools.pauseProgram();
                    break;
                case 3: // Show car details
                    System.out.println("You chose option 3. Let's show the car details!");
                    Car.showCarDetails();
                    Tools.pauseProgram();
                    break;
                case 4: // Show service details
                    System.out.println("You chose option 4. Let's show the service details!");
                    Service.showServiceDetails();
                    Tools.pauseProgram();
                    break;
                case 5: // Add Maintenance
                    System.out.println("You chose option 5. Let's add maintenance!");
                    Maintenance.addMaintenance();
                    Tools.pauseProgram();
                    break;
                case 6: // Show Maintenance by Invoice
                    System.out.println("You chose option 6. Let's show maintenance by invoice!");
                    Maintenance.showMaintenanceByInvoice();
                    Tools.pauseProgram();
                    break;
                case 7: // Show all maintenance
                    System.out.println("You chose option 7. Let's show all maintenance!");
                    Maintenance.showAllMaintenance();
                    Tools.pauseProgram();
                    break;
                case 8: // Get Help!
                    System.out.println("You chose option 8. Let's get some help!");
                    Tools.getHelp();
                    Tools.pauseProgram();
                    break;
                case 9: // Exit program
                    System.out.println("Exiting the program.");
                    Tools.endProgram();
                    break;
                default: // Otherwise, tell them this.
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        } while (choice != 9);

        sc.close();
    }

    // </editor-fold>
}