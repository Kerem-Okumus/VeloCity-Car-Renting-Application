package Objects;

import java.sql.Date;

public class Reservation {
    private int reservationId;
    private Date pickupDate;
    private Date returnDate;
    private String pickupLocation;
    private String returnLocation;
    private int resStatus;
    private int price;
    private int userId;
    private int vehicleId;
    private int driverId;

    public Reservation(int reservationId, Date pickupDate, Date returnDate, String pickupLocation, String returnLocation, int resStatus, int price, int userId, int vehicleId) {
        this.reservationId = reservationId;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.resStatus = resStatus;
        this.price = price;
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public int getResStatus() {
        return resStatus;
    }

    public int getPrice() {
        return price;
    }

    public int getUserId() {
        return userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public void setResStatus(int resStatus) {
        this.resStatus = resStatus;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
