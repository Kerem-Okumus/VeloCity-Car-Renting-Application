import Objects.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeloCityDatabase {

    static Connection connection = DBConnection.getConnection();

    public void addCar(Car car) {

    }

    public static void main(String[] args) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicle");

        while (resultSet.next()) {
            int vehicleId = resultSet.getInt("vehicleId");
            String gearType = resultSet.getString("gearType");
            String color = resultSet.getString("color");
            String carType = resultSet.getString("carType");
            String model = resultSet.getString("model");
            String brand = resultSet.getString("brand");
            boolean isAvailable = resultSet.getBoolean("isAvailable");
            String fuelType = resultSet.getString("fuelType");
            int passengerAmount = resultSet.getInt("passengerAmount");

            System.out.println("Vehicle ID: " + vehicleId);
            System.out.println("Gear Type: " + gearType);
            System.out.println("Color: " + color);
            System.out.println("Car Type: " + carType);
            System.out.println("Model: " + model);
            System.out.println("Brand: " + brand);
            System.out.println("isAvailable: " + isAvailable);
            System.out.println("Fuel Type: " + fuelType);
            System.out.println("Passenger Amount: " + passengerAmount);
        }
    }
}
