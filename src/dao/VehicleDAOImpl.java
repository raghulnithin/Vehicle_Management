package dao;

import database.DatabaseConnection;
import models.Vehicle;
import models.Car;
import models.Bike;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (type, brand, model, year) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String type = vehicle instanceof Car ? "Car" : "Bike";

            stmt.setString(1, type);
            stmt.setString(2, vehicle.getBrand());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());

            stmt.executeUpdate();
            System.out.println("✅ Vehicle inserted into database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String type = rs.getString("type");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int year = rs.getInt("year");

                Vehicle vehicle;
                if (type.equalsIgnoreCase("Car")) {
                    vehicle = new Car(brand, model, year, 4);
                } else {
                    vehicle = new Bike(brand, model, year, true);
                }

                list.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
