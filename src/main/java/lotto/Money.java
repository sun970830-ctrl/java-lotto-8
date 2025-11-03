package lotto;

public class Money {
    private static final int UNIT = 1000;

    private final int amount;

    public Money(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        this.amount = amount;
    }

    public int ticketCount() {
        return amount / UNIT;
    }

    public int amount() {
        return amount;
    }
}