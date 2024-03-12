/*
Title: Tools
Author: Draedn Groves
Date: Mar.8th/2024
Purpose: Tools class with utility based things
 */


import java.util.Scanner;

public class Tools {

    // Simple pause program method
    public static void pauseProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Waits for user to hit Enter
    }

    // Option 8 in my menu
    public static void getHelp() {
        System.out.println("A service representative will be with you shortly, please wait patiently. ");
    }

    // Simple end method
    public static void endProgram() {
        System.exit(0);
    }
    // Asked ChatGPT 3.5 "How would I implement a simple and concise method to end the program
    // assuming the user presses 9 in the switch case menu options?" {Mar.10th @2pm ish} = Answer is above


}
