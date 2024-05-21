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

    public int getUserId() {
        return userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
