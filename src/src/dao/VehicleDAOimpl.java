package dao;
import database.DatabaseConnection;
import models.Car;
import models.Bike;
import models.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public void addVehicle(Vehicle vehicle) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO vehicles (type, brand, model, year) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, (vehicle instanceof Car) ? "Car" : "Bike");
            stmt.setString(2, vehicle.brand);
            stmt.setString(3, vehicle.model);
            stmt.setInt(4, vehicle.year);
            stmt.executeUpdate();
            System.out.println("Vehicle added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM vehicles";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int year = rs.getInt("year");

                if (type.equals("Car")) {
                    vehicles.add(new Car(brand, model, year, 4));
                } else {
                    vehicles.add(new Bike(brand, model, year, true));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
