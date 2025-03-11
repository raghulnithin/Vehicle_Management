package models;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year);
        this.doors = doors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car: " + brand + " " + model + ", Year: " + year + ", Doors: " + doors);
    }
}
