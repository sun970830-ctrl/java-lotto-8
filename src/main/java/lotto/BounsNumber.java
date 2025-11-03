package lotto;

public class BounsNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int value;

    public BounsNumber(Lotto winning, int bonus) {
        if (bonus < MIN || bonus > MAX) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winning.numbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.value = bonus;
    }

    public int value() {
        return value;
    }
}