/*
Title: Car Class
Author: Draedn Groves
Date: Mar.5th/2024
Purpose: A class containing car properties
 */

/* I obtained this version of the Car class from
https://github.com/rcmacdon/COSC1200_Section02_w24_DemoProjects/blob/main/Week6_ArrayLists_Classes/src/Service.java
As per instructions in Assignment 3.
 */

import java.util.ArrayList;
import java.util.Scanner;

// car class
public class Car {

    public static ArrayList<Car> cars;
    private static int autoVin = 1;

    //<editor-fold desc="Properties">
    private int vin;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String color;
    private String owner;
    //</editor-fold>

    //<editor-fold desc="Constructors">

    // default constructor
    public Car(){}

    // parameterized constructor
    public Car(int vin, int year, String make, String model,
               String trim, String color, String owner){
        setVin(vin);
        setYear(year);
        setMake(make);
        setModel(model);
        setTrim(trim);
        setColor(color);
        setOwner(owner);
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public int getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getTrim() { return trim; }
    public String getColor() { return color; }
    public String getOwner() { return owner; }

    public void setVin (int vin){
        // validation
        if (vin == 0) {
            vin = autoVin++;
        }
        this.vin = vin;
    }
    public void setYear (int year){ this.year = year; }
    public void setMake (String make){ this.make = make; }
    public void setModel (String model){ this.model = model; }
    public void setTrim (String trim){ this.trim = trim; }
    public void setColor (String color){ this.color = color; }
    public void setOwner (String owner){ this.owner = owner; }


    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    public void printCar() {
        System.out.println(String.format("""
                 -------------------------------
                 vin: %d - %s %d %s %s %s
                    owner: %s
                 -------------------------------
                 """, getVin(), getColor(), getYear(), getMake(), getModel(), getTrim(), getOwner()));
    }

    // 3. Show car details
    public static void showCarDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a VIN:");
        int vin = sc.nextInt();
        // Find the car with the given VIN
        Car car = Car.findCarByVIN(vin, Car.cars);
        if (car != null) {
            System.out.println(car.toString(vin));
        } else {
            System.out.println("No car found with the given VIN.");
        }
    }
    //</editor-fold>

    //<editor-fold desc="Static Methods">
    public static Car findCarByVIN(int vin, ArrayList<Car> cars) {
        Car retCar = new Car();
        for (Car car: cars) {
            if (car.getVin() == vin) retCar = car;
        }
        return retCar;
    }

    // 1. Populate Car List
    public static void populateCarList() {
        // the following code was provided by Prof. Clint MacDonald and has been implemented exactly as provided.
        // I have created the method to wrap around this code.
        Car.cars = new ArrayList<Car>();
        Car.cars.add(new Car(0,2022,"Honda","Civic","DX","Black","Clint MacDonald"));
        Car.cars.add(new Car(0,2019,"Acura", "MDX", "", "Silver","John Glenn"));
        Car.cars.add(new Car(0,2022,"Ford","Mustang","GT","Red","Ford Canada"));
        Car.cars.add(new Car(0,2020,"Toyota","Camry","Hybrid","Blue","Raj Patel"));
        Car.cars.add(new Car(0,2018,"Jeep","Wrangler","Sahara","Green","Sarah Smith"));
        Car.cars.add(new Car(0,2017,"Chevrolet","Silverado","1500","Gray","Gerry McLeod"));
        Car.cars.add(new Car(0,2023,"Subaru","Outback","Limited","White","Christina McGlaughlin"));
        Car.cars.add(new Car(0,2016,"Porsche","911","Carrera","Yellow","Bob Spears"));
        Car.cars.add(new Car(0,2024,"Audi","A4","Quattro","Dark Blue","Stephen Forbes"));
        Car.cars.add(new Car(0,2025,"Tesla","Model S","Plaid","Midnight Silver","Jennifer Short"));

        System.out.println("The car list has been populated. ");
    }
    //</editor-fold>

    // Returns a String of the details of a single car with the vin as an input parameter
    public String toString(int vin) {
        Car car = findCarByVIN(vin, cars);
        return String.format("VIN: %d, Color: %s, Year: %d, Make: %s, Model: %s, Owner: %s",
                car.getVin(), car.getColor(), car.getYear(), car.getMake(), car.getModel(), car.getOwner());
    }

    // Returns a String to display a table of all cars
    public static String toTable(ArrayList<Car> cars) {
        StringBuilder table = new StringBuilder();
        table.append("VIN | COLOR | YEAR | Make | Model | Owner\n");
        table.append("----|-------|------|------|-------|------\n");
        for (Car car : cars) {
            table.append(String.format("%d | %s | %d | %s | %s | %s\n",
                    car.getVin(), car.getColor(), car.getYear(), car.getMake(), car.getModel(), car.getOwner()));
        }
        return table.toString();
    }
}
