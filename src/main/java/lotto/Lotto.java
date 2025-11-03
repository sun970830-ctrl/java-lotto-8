package lotto;

import java.util.*;

public class Lotto {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        this.numbers = Collections.unmodifiableList(sorted);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for (int n : numbers) {
            if (n < MIN || n > MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    public List<Integer> numbers() {
        return numbers;
    }
}
