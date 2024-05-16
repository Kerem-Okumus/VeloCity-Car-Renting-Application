import Objects.*;
import Objects.Driver;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {

    static Connection connection = DBConnection.getConnection();

    private ArrayList<User> userArrayList =new ArrayList<>();
    private ArrayList<Vehicle> vehicleArrayList =new ArrayList<>();
    private ArrayList<Driver> driverArrayList =new ArrayList<>();
    private ArrayList<Extras> extrasArrayList =new ArrayList<>();
    private ArrayList<Reservation> reservationArrayList =new ArrayList<>();
    private ArrayList<ReservationExtras> reservationExtrasArrayList =new ArrayList<>();
    private int loggedUserId;
    private ArrayList<String> promotionCodes = new ArrayList<>();

    public Model() throws SQLException {
        getUsersInDB();
        getVehiclesInDB();
        getDriversInDB();
        getExtrasInDB();
        getReservationsInDB();
        getReservationExtrasInDB();
        determinePromotionCodes();
    }

    public void determinePromotionCodes(){
        promotionCodes.add("mcqueen10");
        promotionCodes.add("blackfriday15");
        promotionCodes.add("alonso20");
    }

    public int addUser(User user)  {
        userArrayList.add(user);
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

    public boolean signUp(String userName, String password, String passwordCheck, String eMail, String birthday, String phone, String gender) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs1 = statement.executeQuery("SELECT userName FROM User");

        //checkValidInfoForSignUp(userName, password, passwordCheck, eMail, birthday, phone, gender);
        if(checkValidInfoForSignUp(userName, password, passwordCheck, eMail, birthday, phone, gender)==false){
            return false;
        }

        while (rs1.next()) {
            String activeUserName = rs1.getString("userName");
            if(userName.equals(activeUserName)){
                JOptionPane.showMessageDialog(new JFrame(),"--- This username has taken ---");
                return false;
            }
        }

        User newUser=new User(userName, password, userName, eMail, Integer.parseInt(birthday), phone, gender,null);
        addUser(newUser);

        return true;
    }

    public boolean checkValidInfoForSignUp(String userName, String password, String passwordCheck, String eMail, String age, String phone, String gender){

        String errorMessage="";
        int flag =0;
        int ageFlag=0;

        if(age.equals("") || age.contains(" ")){
            ageFlag=1;
        }

        if(userName.equals("") || password.equals("") || passwordCheck.equals("") || eMail.equals("") || age.equals("") || phone.equals("") || gender.equals("")){
            errorMessage+="!! PLEASE FILL ALL THE FIELDS !!\n";
            flag=1;
        }
        if(!password.equals(passwordCheck)){
            errorMessage+="!! PLEASE ENTER THE SAME PASSWORD !!\n";
            flag=1;
        }

        String regex ="^(.+)@(.+)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(eMail);
        if(!matcher.matches()){
            errorMessage+="!! PLEASE ENTER A VALID E-MAIL !!\n";
            flag=1;
        }

        if(!isNumeric(age)){
            errorMessage+="!! PLEASE ENTER A VALID AGE !!\n";
            flag=1;
        }else if(Integer.parseInt(age)>100 || Integer.parseInt(age)<18){
            errorMessage+="!! YOU ARE NOT ELIGIBLE (age) !!\n";
            flag=1;
        }
        if(!isNumeric(phone) || !phone.startsWith("05") || phone.length() != 11){
            errorMessage+="!! PLEASE ENTER A VALID PHONE NUMBER !!\n";
            flag=1;
        }
        if(gender==null){
            errorMessage+="!! PLEASE SELECT GENDER !!";
            flag=1;
        }
        if(flag==1) {
            JOptionPane.showMessageDialog(new JFrame(), errorMessage);
            return false;
        }
        return true;
    }

    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
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
        String query = "SELECT * FROM vehicle ";
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
            String dailyPrice = resultSet.getString("dailyPrice");
            Vehicle existingVehicle = new Vehicle(vehicleId, gearType, color, carType, model, brand, isAvailable, fuelType, passengerAmount, dailyPrice);
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
        String query = "SELECT * FROM Reservation ";
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
            Reservation existingReservation = new Reservation(reservationId, pickupDate, returnDate, pickupLocation, returnLocation, resStatus, price, userId, vehicleId);
            existingReservation.setDriverId(driverId);
            reservationArrayList.add(existingReservation);
        }
    }

    public void getReservationExtrasInDB() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM reservationExtras ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int reservationId = resultSet.getInt("reservationId");
            int extraId = resultSet.getInt("extraId");
            ReservationExtras existingReservationExtras = new ReservationExtras(reservationId, extraId);
            reservationExtrasArrayList.add(existingReservationExtras);
        }
    }

    public boolean logIn(String username, String password) throws SQLException {
        Statement statement = connection.createStatement();
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(new JFrame(),"PLEASE FILL BOTH FIELDS !!!");
            return false;
        }
        ResultSet rs1 = statement.executeQuery("SELECT username, userId " +
                "FROM user " +
                        "WHERE username='" + username + "' and password= '" + password +"';");

        if (rs1.next()) {
            System.out.println("NOTIFICATION >>> Welcome " + rs1.getString("username"));
            loggedUserId = rs1.getInt("userId");
            return true;
        } else {
            System.out.println("NOTIFICATION >>> Wrong username or password");
            JOptionPane.showMessageDialog(new JFrame(),"WRONG USERNAME OR PASSWORD !!!");
        }
        return false;
    }


    public int addReservation(Date pickupDate, Date returnDate, String pickupLocation, String returnLocation, int resStatus, double price, int userId, int vehicleId){
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


            statement.executeUpdate("INSERT INTO Reservation (reservationId, pickupDate, returnDate, pickupLocation, returnLocation ,resStatus , price , userId , vehicleId , driverId) VALUES ( '" + reservationId
                    + "' , '" + pickupDate + "', '" + returnDate + "' , '" + pickupLocation+ "' , '" + returnLocation + "' , '" + resStatus
                    + "' , '" + price + "' , '" + userId + "','" +vehicleId + "',null)");
            System.out.println("NOTIFICATION >>> Reservation   with id " + reservationId + " added to Reservations! <<<");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Reservation reservation = new Reservation(reservationId,pickupDate,returnDate,pickupLocation,returnLocation,resStatus,(int) price,userId,vehicleId);
        reservationArrayList.add(reservation);
        return reservationId;

    }

    public void addExtrastoReservation(int reservationId,ArrayList<Integer> extraId) throws SQLException {
        Statement statement = connection.createStatement();
        for(int i=0;i<extraId.size();i++){
            statement.executeUpdate("INSERT INTO reservationExtras (reservationId, extraId) VALUES ( '" + reservationId
                    + "' , '"  +extraId.get(i) + "')");
            System.out.println("NOTIFICATION >>> ReservationExtra   with  reservationId " + reservationId + " and with extrasId "+extraId.get(i)+"has been added to DB <<<");
        }
    }
    public void assignDriver(boolean isExperienced, int reservationId) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs1;
        if(isExperienced){
            rs1 = statement.executeQuery("SELECT driverId FROM Driver WHERE isExperienced=true and isAvailable=true");
        }
        else{
            rs1 = statement.executeQuery("SELECT driverId FROM Driver WHERE isExperienced=false and isAvailable=true");
        }
        if (rs1.next()) {
            int driverId = rs1.getInt("driverId");
            statement.executeUpdate("UPDATE Reservation SET driverId =" + driverId + " WHERE reservationId =" + reservationId);
            statement.executeUpdate("UPDATE Driver SET isAvailable = 0 WHERE driverId =" + driverId);
        } else {
            System.out.println("No available driver found.");
        }
        rs1.close();
        statement.close();
    }

    public void addPaymentInformation(String cardNumber, String cvv, String lastDateYear, String lastDateMonth, String lastDateDay, User user) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE user SET cardNumber=" + cardNumber + ",cvv=" + cvv + ",lastDateYear=" + lastDateYear + ",lastDateMonth=" + lastDateMonth + ",lastDateDay=" + lastDateDay + " WHERE userId= " + user.getUserId());

        for(int i = 0; i<userArrayList.size(); i++){
            if(userArrayList.get(i).getUserId() == user.getUserId()){
                userArrayList.get(i).setCvv(cvv);
                userArrayList.get(i).setLastDateYear(lastDateYear);
                userArrayList.get(i).setLastDateMonth(lastDateMonth);
                userArrayList.get(i).setLastDateDay(lastDateDay);
            }
        }
    }


    public ResultSet filterCars(String brand, String category, String color, String gearType, int passenger,Date pickupDate, Date deliverDate) throws SQLException {
        Statement statement = connection.createStatement();
        StringBuilder queryBuilder = new StringBuilder("SELECT V.vehicleId, V.gearType, V.color, V.carType, V.model, V.brand, V.isAvailable, V.fuelType, V.passengerAmount, V.dailyPrice FROM Vehicle V WHERE V.vehicleId NOT IN(SELECT R.vehicleId FROM Reservation R WHERE R.pickupDate <= '" + deliverDate + "' AND R.returnDate >= '" + pickupDate + "')" );
        if (!"ALL".equals(brand)) {
            queryBuilder.append(" AND V.brand = '").append(brand).append("'");
        }
        if (!"ALL".equals(gearType)) {
            queryBuilder.append(" AND V.gearType = '").append(gearType).append("'");
        }
        if (!"ALL".equals(category)) {
            queryBuilder.append(" AND V.carType = '").append(category).append("'");
        }
        if (!"ALL".equals(color)) {
            queryBuilder.append(" AND V.color = '").append(color).append("'");
        }
        if (passenger != -1) { // assuming -1 represents "ALL" for passenger count
            queryBuilder.append(" AND V.passengerAmount = ").append(passenger);
        }
        ResultSet rs1 = statement.executeQuery(queryBuilder.toString());
        return rs1;
    }
    public ArrayList<Vehicle> showFilteredCars(ResultSet rs1) throws SQLException {
        ArrayList<Vehicle> cars = new ArrayList<>();
        while(rs1.next()){
            int vehicleId = rs1.getInt("vehicleId");
            String gearType = rs1.getString("gearType");
            String color = rs1.getString("color");
            String carType = rs1.getString("carType");
            String model = rs1.getString("model");
            String brand = rs1.getString("brand");
            boolean isAvailable = rs1.getBoolean("isAvailable");
            String fuelType = rs1.getString("fuelType");
            String passengerAmount = rs1.getString("passengerAmount");
            String dailyPrice = rs1.getString("dailyPrice");
            cars.add(new Vehicle(vehicleId, gearType, color, carType, model, brand, isAvailable, fuelType, passengerAmount, dailyPrice));
        }
        return cars;
    }

    public boolean paymentValidation(String nameOnTheCard, String cardNumber, String cvv, String promotionCode){

        String cardName = nameOnTheCard;
        cardName = cardName.replaceAll("\\s+","") ;
        promotionCode = promotionCode.toLowerCase();

        String errorMessage="";
        int flag=0;

        if(nameOnTheCard.equals("") || cardNumber.equals("") || cvv.equals("")){
            errorMessage += "!! PLEASE FILL ALL REQUIRED FIELDS !!\n";
            flag=1;
        }else {
            if (checkStringIfItIsFullOfLetters(cardName) == false) {
                errorMessage += "!! PLEASE ENTER ONLY LETTERS IN NAME FIELD !!\n";
                flag = 1;
            }
            if (!isNumeric(cardNumber)) {
                errorMessage += "!! PLEASE ENTER ONLY INTEGERS IN CARD NUMBER FIELD !!\n";
                flag = 1;
            } else if (cardNumber.length() != 16) {
                errorMessage += "!! INVALID CARD NUMBER (NEED 16 DIGITS) !!\n";
                flag = 1;
            }
            if (!isNumeric(cvv)) {
                errorMessage += "!! PLEASE ENTER ONLY INTEGERS IN CCV !!\n";
                flag = 1;
            } else if (cardNumber.length() != 16) {
                errorMessage += "!! INVALID CCV (NEED 3 DIGITS) !!\n";
                flag = 1;
            }
            if (!promotionCodes.contains(promotionCode) && !promotionCode.equals("")) {
                errorMessage += "!! INVALID PROMOTION CODE !!\n";
                flag = 1;
            }
        }

        if(flag==1){
            JOptionPane.showMessageDialog(new JFrame(), errorMessage);
            return false;
        }

        return true;
    }

    public boolean checkStringIfItIsFullOfLetters(String string){
        for(char c : string.toCharArray()){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
    public int validateDriver(Date pickupDate, Date deliverDate, boolean isExperienced) throws SQLException {
        int i;
        if(isExperienced)
            i=1;
        else{
            i=0;
        }
        Statement statement = connection.createStatement();
        ResultSet rs1 = statement.executeQuery("SELECT distinct D.driverId FROM Driver D, Reservation R WHERE D.driverId NOT IN(SELECT R.driverId FROM Reservation R WHERE R.pickupDate <= '" + deliverDate + "' AND R.returnDate >= '" + pickupDate + "') AND  D.isExperienced ='"+i+"' ORDER BY D.driverId ASC");
        if(rs1.next()){
            System.out.println(rs1.getInt("driverId"));
            return rs1.getInt("driverId");
        }
        rs1.close();
        return -1;
    }

    public boolean extrasValidation(String selectedDriver, String selectedDriverPreference, String selectedSeat, String selectedTireChain, String selectedRoofBox, String selectedProtection){

        if(selectedDriver==null || selectedTireChain==null || selectedRoofBox==null || selectedProtection==null){
            JOptionPane.showMessageDialog(new JFrame(),"!! PLEASE FILL EXTRAS PART !!");
            return false;
        }
        if(selectedDriver.equals("Yes") && selectedDriverPreference==null){
            JOptionPane.showMessageDialog(new JFrame(),"!! PLEASE SELECT DRIVER TYPE !!");
            return false;
        }
        if(selectedDriver.equals("No") && selectedDriverPreference!=null){
            JOptionPane.showMessageDialog(new JFrame(),"!! DON'T SELECT PREFERENCE IF NO NEED DRIVER !!");
            return false;
        }
        return true;
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

    public int getLoggedUserId() {
        return loggedUserId;
    }
}
