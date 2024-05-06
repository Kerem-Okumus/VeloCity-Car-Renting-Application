import Objects.*;
import Objects.Driver;

import java.sql.*;
import java.util.ArrayList;

public class Model {

    static Connection connection = DBConnection.getConnection();

    private ArrayList<User> userArrayList =new ArrayList<>();
    private ArrayList<Vehicle> vehicleArrayList =new ArrayList<>();
    private ArrayList<Driver> driverArrayList =new ArrayList<>();
    private ArrayList<Extras> extrasArrayList =new ArrayList<>();
    private ArrayList<Reservation> reservationArrayList =new ArrayList<>();
    private ArrayList<ReservationExtras> reservationExtrasArrayList =new ArrayList<>();

    public Model() throws SQLException {
        getUsersInDB();
        getVehiclesInDB();
        getDriversInDB();
        getExtrasInDB();
        getReservationsInDB();
        getReservationExtrasInDB();
    }

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
    }

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

    public void getExtrasInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT extraId, extraName, price FROM extras ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int extraId = resultSet.getInt("extraId");
            String extraName = resultSet.getString("extraName");
            int price = resultSet.getInt("price");
            Extras existingExtras = new Extras(extraId, extraName, price);
            extrasArrayList.add(existingExtras);
        }
    }

    public void getReservationsInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT reservationId, pickupDate, returnDate, pickupLocation, returnLocation, resStatus, price, userId, vehicleId, driverId, extraId FROM driver ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int reservationId = resultSet.getInt("reservationId");
            Date pickupDate = resultSet.getDate("pickupDate");
            Date returnDate = resultSet.getDate("returnDate");
            String pickupLocation = resultSet.getString("pickupLocation");
            String returnLocation = resultSet.getString("returnLocation");
            int resStatus = resultSet.getInt("resStatus");
            int price = resultSet.getInt("price");
            int userId = resultSet.getInt("userId");
            int vehicleId = resultSet.getInt("vehicleId");
            int driverId = resultSet.getInt("driverId");
            int extraId = resultSet.getInt("extraId");
            Reservation existingReservation = new Reservation(reservationId, pickupDate, returnDate, pickupLocation, returnLocation, resStatus, price, userId, vehicleId);
            reservationArrayList.add(existingReservation);
        }
    }

    public void getReservationExtrasInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT reservationId, extraId FROM extras ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int reservationId = resultSet.getInt("reservationId");
            int extraId = resultSet.getInt("extraId");
            ReservationExtras existingReservationExtras = new ReservationExtras(reservationId, extraId);
            reservationExtrasArrayList.add(existingReservationExtras);
        }
    }

    public String logIn(String username, String password) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs1 = statement.executeQuery("SELECT username " +
                "FROM user " +
                        "WHERE username='" + username + "' and password= '" + password +"';");


        if (rs1.next()) {
            System.out.println("NOTIFICATION >>> Welcome " + rs1.getString("username"));
            return username;
        } else {
            System.out.println("NOTIFICATION >>> Wrong username or password");
        }


        return "Wrong username";
    }
    public void addReservation(Date pickupDate, Date returnDate, String pickupLocation, String returnLocation, int resStatus, double price, int userId, int vehicleId){
        int lastId = 0;
        int reservationId = 0;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs1 = statement.executeQuery("SELECT MAX(reservationId) FROM Reservation");

            while (rs1.next()) {
                lastId = rs1.getInt(1);
            }

            if (lastId == 0) {
                reservationId = 1;
            } else {
                reservationId = lastId + 1;
            }


            statement.executeUpdate("INSERT INTO Reservation (reservationId, pickupDate, returnDate, pickupLocation, returnLocation ,resStatus , price , userId , vehicleId) VALUES ( '" + reservationId
                    + "' , '" + pickupDate + "', '" + returnDate + "' , '" + pickupLocation+ "' , '" + returnLocation + "' , '" + resStatus
                    + "' , '" + price + "' , '" + userId + "','" +vehicleId + "')");
            System.out.println("NOTIFICATION >>> Reservation   with id " + reservationId + " added to Reservations! <<<");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addExtrastoReservation(int reservationId,ArrayList extraId) throws SQLException {
        Statement statement = connection.createStatement();
        for(int i=0;i<extraId.size();i++){
            statement.executeUpdate("INSERT INTO reservationExtras (reservationId, extraId,) VALUES ( '" + reservationId
                    + "' , '"  +extraId + "')");
            System.out.println("NOTIFICATION >>> ReservationExtra   with  reservationId " + reservationId + " and with extrasId "+extraId.get(i)+"has been added to DB <<<");
        }

    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    public ArrayList<Driver> getDriverArrayList() {
        return driverArrayList;
    }

    public ArrayList<Extras> getExtrasArrayList() {
        return extrasArrayList;
    }

    public ArrayList<Reservation> getReservationArrayList() {
        return reservationArrayList;
    }

    public ArrayList<ReservationExtras> getReservationExtrasArrayList() {
        return reservationExtrasArrayList;
    }
}
