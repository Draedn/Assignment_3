/*
Title: Service class
Author: Draedn Groves
Date: Mar.7th/2024
Purpose: A class containing a list of services
 */


/* I obtained this version of the Service class from
https://github.com/rcmacdon/COSC1200_Section02_w24_DemoProjects/blob/main/Week6_ArrayLists_Classes/src/Service.java
As it was a cleaner version of what I did for ICE2.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Service {

    //<editor-fold desc="Class Global Variables">
    public static ArrayList<Service> services;


    //</editor-fold>

    //<editor-fold desc="Properties">
    private String serviceCode;
    private String serviceName;
    private String description;
    private double basePrice;
    private double timeRequired;
    private boolean isActive;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Service() {
        setDefaults();
    }

    public Service(String serviceCode, String serviceName, String description,
                   double basePrice, double timeRequired, boolean isActive) {
        setServiceCode(serviceCode);
        setServiceName(serviceName);
        setDescription(description);
        setBasePrice(basePrice);
        setTimeRequired(timeRequired);
        setActive(isActive);
    }

    public Service(String serviceCode, String serviceName) {
        setDefaults();
        setServiceCode(serviceCode);
        setServiceName(serviceName);
    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        if (serviceCode.length() == 4) {
            if (isServiceCodeUnique(serviceCode)) {
                this.serviceCode = serviceCode;
            } else {
                System.out.println("Service Code is not unique!");
            }
        } else {
            System.out.println("Service code must be a 4-digit alphanumeric value!");
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        if (serviceName.length() > 50) {
            System.out.println("50 character max exceeded.");
        } else {
            this.serviceName = serviceName;
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0 || basePrice > 5000) {
            System.out.println("Price out of range 0-5000.");
        } else {
            this.basePrice = basePrice;
        }

    }

    public double getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(double timeRequired) {
        if (timeRequired >= 0 && timeRequired <= 100) {
            this.timeRequired = timeRequired;
        } else {
            System.out.println("Time for service outside of range.");
        }
    }


    public boolean getIsActive() {
        return isActive;
    }


    public void setActive(boolean active) {
        isActive = active;
    }
    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    @Override
    public String toString() {
        return "Services{" +
                "serviceCode='" + this.serviceCode + '\'' +
                ", serviceName='" + this.serviceName + '\'' +
                ", description='" + this.description + '\'' +
                ", basePrice=" + this.basePrice +
                ", timeRequired=" + this.timeRequired +
                ", isActive=" + this.isActive +
                '}';
    }

    public static void showServiceDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a service code:");
        String serviceCode = sc.nextLine();
        // Find the service with the given service code
        Service service = findServiceByCode(serviceCode, services);
        if (service != null) {
            System.out.println(service.toString(serviceCode));
        } else {
            System.out.println("No service found with the given service code.");
        }
    }

    private void setDefaults() {
        this.serviceCode = "";
        this.serviceName = "Default Service";
        this.description = "";
        this.basePrice = 0.00;
        this.timeRequired = 0.00;
        this.isActive = false;
    }

    // Return a String of the details of a single service with the service code as an input parameter
    public String toString(String serviceCode) {
        Service service = findService(serviceCode, services);
        if (service == null) {
            return "Service with Code " + serviceCode + " not found.";
        } else {
            return service.toString();
        }
    }
    //</editor-fold>

    //<editor-fold desc="Static Methods">
    // Returns a String to display a table of all services
    public static String toTable(ArrayList<Service> services) {
        StringBuilder table = new StringBuilder();
        table.append("Service Code | Service Name | Description | Base Price | Time Required | Active\n");
        table.append("-------------|--------------|-------------|------------|---------------|-------\n");
        for (Service service : services) {
            table.append(String.format("%s | %s | %s | %.2f | %.2f | %b\n",
                    service.getServiceCode(), service.getServiceName(), service.getDescription(), service.getBasePrice(),
                    service.getTimeRequired(), service.getIsActive()));
        }
        return table.toString();
    }

    // In your Service class
    public static void populateServiceList() {
        // the following code was provided by Prof. Clint MacDonald and has been implemented exactly as provided.
        // I have created the method to wrap around this code.
        Service.services = new ArrayList<Service>();
        Service.services.add(new Service("OCF2","Foreign Oil/Filter","Foreign oil change and filter replacement",109.99f,30,true));
        Service.services.add(new Service("OCD2","Domestic Oil/Filter","Domestic oil change and filter replacement",79.99f,30,true));
        Service.services.add(new Service("TR01","Tire Rotation and Balance","Clockwise Rotation of 4 tires with balancing",59.99f,30,true));
        Service.services.add(new Service("WB01","Wiper Blade Inspection","Inspect wiper blades for cracks and defects",9.99f,5,true));
        Service.services.add(new Service("AF02","Air Filter Replacement","Replace engine air filter",29.99f,10,true));
        Service.services.add(new Service("TF02","Transmission Fluid Flush","Flush and replace transmission fluid",79.99f,40,true));
        Service.services.add(new Service("BFF2","Brake Fluid Flush","Flush and replace brake fluid",69.99f,30,true));
        Service.services.add(new Service("BP01","Brake Inspection","Inspect brakes for percentage remaining and unusual wear and tear.",34.99f,15,true));
        Service.services.add(new Service("BPF2","Front Brake Pad Replacement","Replace front brake pads",119.00f,60,true));
        Service.services.add(new Service("BPR2","Rear Brake Pad Replacement","Replace rear brake pads",119.00f,60,true));
        Service.services.add(new Service("SP02","Spark Plug Replacement","Replace spark plugs, includes plugs",104.99f,30,true));
        Service.services.add(new Service("SA01","Steering Alignment","Align front wheels for steering",59.99f,30,true));
        Service.services.add(new Service("RA02","Radio Installation","Install new custom radio",99.99f,60,true));
        Service.services.add(new Service("TB02","Timing Belt Replacement","Replace timing belt",349.99f,300,true));
        Service.services.add(new Service("WI01","Winter Undercoating","Undercoating for rust proofing/winterization",119.00f,45,true));
        Service.services.add(new Service("WT02","Winter Tire Installation","Install 4 winter tires with balance",79.99f,60,true));
        Service.services.add(new Service("WF01","Washer Fluid Top-up","Top-up washer fluid",0.00f,5,true));

        System.out.println("The service list has been populated. ");
    }

    // Returns the default price of a service given the service code
    public static double getPrice(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service.getBasePrice();
            }
        }
        return 0.00;
    }


    public static Service findService(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service;
            }
        }

        //returns null when object related with the service code is not found.
        return null;
    }

    private static Boolean isServiceCodeUnique(String serviceCode) {
        for (Service service: services) {
            if (service.serviceCode.equalsIgnoreCase(serviceCode)) return false;
        }
        return true;
    }

    public static Service findServiceByCode(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service;
            }
        }
        return null; // Return null if no service found with the given service code
    }

    //</editor-fold>
}