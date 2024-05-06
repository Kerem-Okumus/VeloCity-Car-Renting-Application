package Objects;

public class Extras {
    private int extraId;
    private String extraName;
    private int price;

    public Extras(int extraId, String extraName, int price) {
        this.extraId = extraId;
        this.extraName = extraName;
        this.price = price;
    }

    public int getExtraId() {
        return extraId;
    }

    public void setExtraId(int extraId) {
        this.extraId = extraId;
    }

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
