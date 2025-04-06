package models;

public class Car extends Vehicle {
    private final int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car: " + brand + " " + model + " (" + year + ") - Doors: " + numberOfDoors);
    }
}
