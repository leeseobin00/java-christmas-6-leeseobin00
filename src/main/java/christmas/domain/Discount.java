package christmas.domain;

public class Discount {
    private final String type;
    private final int amount;

    public Discount(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}