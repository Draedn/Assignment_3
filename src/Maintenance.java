/*
Title: Maintenance
Author: Draedn Groves
Date: Mar.7th/2024
Purpose: Class containing the maintenance of cars in the program
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

// Asked Microsoft Copilot (More Precise), "How would I implement getting the date as a default, without
// specifying what the date is?" [Mar.9th @6:25pm EST] --- {For LocalDate import}

        public class Maintenance {

            // <editor-fold desc="Global Variables">
            public static ArrayList<Maintenance> maintenances = new ArrayList<>();
            // </editor-fold>

            // <editor-fold desc="Maintenance Properties">
            private int vin;
            private String serviceCode;
            private double price;
            private String date;
            private String notes;
            private static int autoInvoiceID = 1001;
            private final int invoiceID;
            // </editor-fold>

            private void setDefaults() {
                this.vin = 0; // Default VIN
                this.serviceCode = ""; // Default service code
                this.price = 0.0; // Default price
                this.date = LocalDate.now().toString(); // Default date is today's date
                this.notes = ""; // Default notes
            }

            private static Maintenance findMaintenanceByInvoiceId(int invoiceId, ArrayList<Maintenance> maintenances) {
                for (Maintenance maintenance : maintenances) {
                    if (maintenance.getInvoiceId() == invoiceId) { // Assuming you have a getInvoiceId() method
                        return maintenance;
                    }
                }
                return null; // Return null if no maintenance found with the given invoice ID
            }

            // <editor-fold desc="Constructors">
            // <editor-fold desc="Default">
            public Maintenance() {
                setDefaults();
                this.invoiceID = autoInvoiceID;
                autoInvoiceID += 13;
            }
            // </editor-fold>

            // Maintenance parameterized constructor
            public Maintenance(int vin, String serviceCode, double price, String date, String notes) {
                this();
                this.vin = vin;
                this.serviceCode = serviceCode;
                this.price = price;
                this.date = date;
                this.notes = notes;
            }

            // <editor-fold desc="Getters & Setters">
            // Getters
            // <editor-fold desc="Getters">
            public int getVin() {
                return vin;
            }
            public int getInvoiceId() {
                return invoiceID;
            }
            public String getServiceCode() {
                return serviceCode;
            }
            public double getPrice() {
                return price;
            }
            public String getDate() {
                return date;
            }
            public String getNotes() {
                return notes;
            }
            // </editor-fold>

            // <editor-fold desc="Setters">
            public void setVin(int vin) {
                this.vin = vin;
            }
            public void setServiceCode(String serviceCode) {
                this.serviceCode = serviceCode;
            }
            public void setPrice(double price) {
                this.price = price;
            }
            public void setDate(String date) {
                this.date = date;
            }
            public void setNotes(String notes) {
                this.notes = notes;
            }
            // </editor-fold>

            // </editor-fold>
            // </editor-fold>

            // <editor-fold desc="Instance Methods">
            public static void showMaintenanceByInvoice() {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter the Invoice ID:");
                int invoiceId = sc.nextInt();
                // Find the maintenance with the given invoice ID
                Maintenance maintenance = findMaintenanceByInvoiceId(invoiceId, maintenances);
                if (maintenance != null) {
                    System.out.println(maintenance);
                } else {
                    System.out.println("No maintenance found with the given invoice ID.");
                }
            }
            // </editor-fold>

            // <editor-fold desc="Static Methods">
            public static void showAllMaintenance() {
                System.out.println(Maintenance.toTable(Maintenance.maintenances));
            }

            // </editor-fold>
            // addMaintenance method
            public static void addMaintenance() {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter the VIN of the car:");
                int vin = sc.nextInt();
                System.out.println("Enter the service code:");
                String serviceCode = sc.next();
                System.out.println("Enter the price to be charged:");
                double price = sc.nextDouble();
                System.out.println("Enter the date (or press Enter for today's date):");
                String date = sc.next();
                if (date.isEmpty()) {
                    date = LocalDate.now().toString(); // Assuming date is a string in the format "yyyy-mm-dd"
                }
                System.out.println("Enter any notes (or press Enter to continue without noting anything): ");
                String notes = sc.next();
                maintenances.add(new Maintenance(vin, serviceCode, price, date, notes));
                System.out.println("Maintenance added. ");
            }


            // toString method
            public String toString() {
                return String.format("Invoice ID: %d, VIN: %d, Service Code: %s, Price: %.2f, Date: %s, Notes: %s",
                        this.getInvoiceId(), this.getVin(), this.getServiceCode(), this.getPrice(), this.getDate(), this.getNotes());
            }

            // toTable method
            public static String toTable(ArrayList<Maintenance> maintenances) {
                StringBuilder table = new StringBuilder();
                table.append("Invoice ID | VIN | Service Code | Price | Date | Notes\n");
                table.append("-----------|-----|--------------|-------|------|------\n");
                for (Maintenance maintenance : maintenances) {
                    table.append(String.format("%d | %d | %s | %.2f | %s | %s\n",
                            maintenance.invoiceID, maintenance.vin, maintenance.serviceCode, maintenance.price, maintenance.date, maintenance.notes));
                }
                return table.toString();
            }
        }
