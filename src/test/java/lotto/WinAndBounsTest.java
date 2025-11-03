package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinAndBounsTest {

    @Test
    void 당첨번호는_6개_중복없이_1에서_45() {
        assertThatCode(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5)))          // 5개
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbers(List.of(1, 1, 2, 3, 4, 5)))      // 중복
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumbers(List.of(0, 2, 3, 4, 5, 46)))     // 범위 밖
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호는_1에서_45_범위이며_당첨번호와_중복불가() {
        WinNumbers win = new WinNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThatCode(() -> new BounsNumber(win.lotto(), 7))
                .doesNotThrowAnyException();

        assertThatThrownBy(() -> new BounsNumber(win.lotto(), 0))   // 범위 아래
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BounsNumber(win.lotto(), 46))  // 범위 위
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BounsNumber(win.lotto(), 6))   // 당첨번호와 중복
                .isInstanceOf(IllegalArgumentException.class);
    }
}