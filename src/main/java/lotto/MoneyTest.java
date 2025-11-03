package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void 천원단위_아니면_예외() {
        assertThatThrownBy(() -> new Money(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 장수_계산() {
        Money money = new Money(14000);
        assertThat(money.ticketCount()).isEqualTo(14);
    }
}