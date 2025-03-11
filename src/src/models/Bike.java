package models;

public class Bike extends Vehicle {
    private boolean hasGear;

    public Bike(String brand, String model, int year, boolean hasGear) {
        super(brand, model, year);
        this.hasGear = hasGear;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike: " + brand + " " + model + ", Year: " + year + ", Gear: " + (hasGear ? "Yes" : "No"));
    }
}
