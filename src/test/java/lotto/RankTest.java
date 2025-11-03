package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RankTest {
    @Test
    void 매칭개수와_보너스에_따라_등수결정() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE);
    }

    @Test
    void 등수별_상금확인() {
        assertThat(Rank.FIRST.prize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.prize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.prize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.prize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.prize()).isEqualTo(5_000);
        assertThat(Rank.NONE.prize()).isEqualTo(0);
    }
}