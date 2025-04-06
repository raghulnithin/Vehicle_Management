package models;

public class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String brand, String model, int year, boolean hasCarrier) {
        super(brand, model, year);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike: " + brand + " " + model + " (" + year + ") - Carrier: " + (hasCarrier ? "Yes" : "No"));
    }
}
