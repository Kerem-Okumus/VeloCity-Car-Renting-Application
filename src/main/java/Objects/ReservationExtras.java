package Objects;

public class ReservationExtras {
    private final int reseravationId;
    private final int extraId;

    public ReservationExtras(int reseravationId, int extraId) {
        this.reseravationId = reseravationId;
        this.extraId = extraId;
    }

    public int getReseravationId() {
        return reseravationId;
    }

    public int getExtraId() {
        return extraId;
    }
}
