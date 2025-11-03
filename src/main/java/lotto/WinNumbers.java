package lotto;

import java.util.List;

public class WinNumbers {
    private final Lotto winning;

    public WinNumbers(List<Integer> numbers) {
        this.winning = new Lotto(numbers);
    }

    public Lotto lotto() {
        return winning;
    }
}