package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {

    static class FixedPicker implements NumbersPicker {
        private final List<Integer> nums;
        FixedPicker(List<Integer> nums) { this.nums = nums; }
        @Override public List<Integer> pick() { return nums; }
    }

    @Test
    void 구입금액만큼_로또를_발행한다() {
        Money money = new Money(5000);
        NumbersPicker picker = new FixedPicker(List.of(1, 2, 3, 4, 5, 6));
        LottoSeller seller = new LottoSeller(picker);

        var tickets = seller.sell(money);

        assertThat(tickets).hasSize(5);
        assertThat(tickets.get(0).numbers()).containsExactly(1, 2, 3, 4, 5, 6);

        for (Lotto t : tickets) {
            assertThat(t.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
        }
    }
}