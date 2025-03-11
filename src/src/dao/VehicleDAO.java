package dao;
import models.Vehicle;
import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}
