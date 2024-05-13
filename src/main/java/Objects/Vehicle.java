package Objects;

public class Vehicle {
    private final int vehicleId;
    private final String gearType;
    private final String color;
    private final String carType;
    private final String model;
    private final String brand;
    private boolean isAvailable;
    private final String fuelType;
    private final String passengerAmount;
    private final String dailyPrice;

    public Vehicle(int vehicleId, String gearType, String color, String carType, String model, String brand,
                   boolean isAvailable, String fuelType, String passengerAmount, String dailyPrice) {
        this.vehicleId = vehicleId;
        this.gearType = gearType;
        this.color = color;
        this.carType = carType;
        this.model = model;
        this.brand = brand;
        this.isAvailable = isAvailable;
        this.fuelType = fuelType;
        this.passengerAmount = passengerAmount;
        this.dailyPrice = dailyPrice;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getGearType() {
        return gearType;
    }

    public String getColor() {
        return color;
    }

    public String getCarType() {
        return carType;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getPassengerAmount() {
        return passengerAmount;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
