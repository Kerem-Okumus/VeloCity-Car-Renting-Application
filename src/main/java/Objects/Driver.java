package Objects;

public class Driver {
    private final int driverId;
    private final int age;
    private final int experienceYear;
    private final int maxSpeed;
    private final boolean isExperienced;

    public Driver(int driverId, int age, int experienceYear, int maxSpeed, boolean isExperienced) {
        this.driverId = driverId;
        this.age = age;
        this.experienceYear = experienceYear;
        this.maxSpeed = maxSpeed;
        this.isExperienced = isExperienced;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getAge() {
        return age;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isExperienced() {
        return isExperienced;
    }
}
