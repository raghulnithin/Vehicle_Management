package main;
import dao.VehicleDAO;
import dao.VehicleDAOImpl;
import models.Car;
import models.Bike;
import models.Vehicle;
import java.util.List;

public class VehicleManagement {
    private List<Vehicle> vehicles;

    public VehicleManagement() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }
}
