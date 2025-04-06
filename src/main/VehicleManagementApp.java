package main;

import dao.VehicleDAO;
import dao.VehicleDAOImpl;
import models.Car;
import models.Bike;
import models.Vehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleManagementApp {
    public static void main(String[] args) {
        VehicleDAO dao = new VehicleDAOImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("🚗 Welcome to Vehicle Management System 🚀");

        while (true) {
            System.out.println("\n📋 Menu:");
            System.out.println("1️⃣  Add Vehicle");
            System.out.println("2️⃣  Show Vehicles");
            System.out.println("3️⃣  Exit");
            System.out.print("👉 Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("\n🔧 Adding a new vehicle...");
                System.out.print("🆔 Brand: ");
                String brand = sc.nextLine();
                System.out.print("📛 Model: ");
                String model = sc.nextLine();
                System.out.print("📅 Year: ");
                int year = sc.nextInt();
                sc.nextLine();

                System.out.println("🚘 Select Vehicle Type:");
                System.out.println("1️⃣  Car");
                System.out.println("2️⃣  Bike");
                int type = sc.nextInt();

                Vehicle vehicle = (type == 1)
                        ? new Car(brand, model, year, 4)
                        : new Bike(brand, model, year, true);

                dao.addVehicle(vehicle);
                System.out.println("✅ Vehicle added successfully!");

            } else if (choice == 2) {
                System.out.println("\n📦git Listing all vehicles:");
                List<Vehicle> vehicles = dao.getAllVehicles();
                vehicles.forEach(Vehicle::displayDetails);

            } else if (choice == 3) {
                System.out.println("👋 Exiting the system. Goodbye!");
                break;
            } else {
                System.out.println("❌ Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
