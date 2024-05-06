import Objects.Driver;
import Objects.User;
import Objects.Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Model {

    static Connection connection = DBConnection.getConnection();

    private ArrayList<User> userArrayList =new ArrayList<>();
    private ArrayList<Vehicle> vehicleArrayList =new ArrayList<>();
    private ArrayList<Driver> driverArrayList =new ArrayList<>();

    public Model() throws SQLException {
        getUsersInDB();
        getVehiclesInDB();
        getDriversInDB();
    } //buraya da kod gelebilir textten çekerken burda direkt dosyayı okuyup userları arrayliste atıyodu bunun sql veriyonu gibi.

    // bu kod admin varmış gibi düşünüldü o yüzden sadece sql ile birlikte nasıl çalıştığının örneği olsun diye koydum
    public int addUser(User user)  {
        int lastId = 0;
        int userId = 0;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs1 = statement.executeQuery("SELECT MAX(userId) FROM User");

            while (rs1.next()) {
                lastId = rs1.getInt(1);
            }

            if (lastId == 0) {
                userId = 1;
            } else {
                userId = lastId + 1;
            }


            statement.executeUpdate("INSERT INTO User (userId, age, userName, password, name_surname,cardNumber, gender,phoneNumber) VALUES ( '" + userId
                    + "' , '" + user.getAge() + "', '" + user.getUsername() + "' , '" + user.getPassword() + "' , '" + user.getName_surname() + "' , '" + user.getCardNumber()
                    + "' , '" + user.getGender() + "' , '" + user.getPhoneNumber() + "')");
            System.out.println("NOTIFICATION >>> Customer " + user.getName_surname() + " with id " + userId + " added to Users <<<");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    } //sample method for adding a customer with a unique id ama username için de unique yaptıralım

    public void getUsersInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT userId, age, userName, password, name_surname, cardNumber, gender, phoneNumber, email FROM user ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int userId = resultSet.getInt("userId");
            int age = resultSet.getInt("age");
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            String name_surname = resultSet.getString("name_surname");
            String cardNumber = resultSet.getString("cardNumber");
            String gender = resultSet.getString("gender");
            String phoneNumber = resultSet.getString("phoneNumber");
            String email = resultSet.getString("email");
            User existingUser = new User(userName, password, name_surname, email, age, phoneNumber, gender, cardNumber);
            existingUser.setUserId(userId);
            userArrayList.add(existingUser);
        }
    }

    public void getVehiclesInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT vehicleId, gearType, color, carType, model, brand, isAvailable, fuelType, passengerAmount FROM vehicle ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int vehicleId = resultSet.getInt("vehicleId");
            String gearType = resultSet.getString("gearType");
            String color = resultSet.getString("color");
            String carType = resultSet.getString("carType");
            String model = resultSet.getString("model");
            String brand = resultSet.getString("brand");
            boolean isAvailable = resultSet.getBoolean("isAvailable");
            String fuelType = resultSet.getString("fuelType");
            String passengerAmount = resultSet.getString("passengerAmount");
            Vehicle existingVehicle = new Vehicle(vehicleId, gearType, color, carType, model, brand, isAvailable, fuelType, passengerAmount);
            vehicleArrayList.add(existingVehicle);
        }
    }

    public void getDriversInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT driverId, age, experienceYear, maxSpeed, isExperienced FROM driver ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int driverId = resultSet.getInt("driverId");
            int age = resultSet.getInt("age");
            int experienceYear = resultSet.getInt("experienceYear");
            int maxSpeed = resultSet.getInt("maxSpeed");
            boolean isExperienced = resultSet.getBoolean("isExperienced");
            Driver existingDriver = new Driver(driverId, age, experienceYear, maxSpeed, isExperienced);
            driverArrayList.add(existingDriver);
        }
    }

    //buraları fonksiyonlarla doldurucaz userın yapacağı sonra controllerdaki actionperformed classında kullanıcaz

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    public ArrayList<Driver> getDriverArrayList() {
        return driverArrayList;
    }
}
