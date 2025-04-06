package models;

public abstract class Vehicle {
    protected int id;
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle() {}

    public Vehicle(int id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }


    public int getId() {
        return id;
    }

    public abstract void displayDetails();
}
