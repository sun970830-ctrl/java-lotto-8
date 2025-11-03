package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 개수_6개_아니면_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복이면_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_벗어나면_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(0,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 오름차순으로_보관() {
        Lotto lotto = new Lotto(List.of(8,1,45,22,3,5));
        assertThat(lotto.numbers()).containsExactly(1,3,5,8,22,45);
    }
}