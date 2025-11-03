package lotto;

import java.util.List;

public class LottoMatcher {
    public Statistics matchAll(List<Lotto> tickets, Lotto winning, BounsNumber bonus) {
        Statistics stats = new Statistics();
        for (Lotto t : tickets) {
            int match = (int) t.numbers().stream().filter(winning.numbers()::contains).count();
            boolean bonusMatched = t.numbers().contains(bonus.value());
            stats.add(Rank.of(match, bonusMatched));
        }
        return stats;
    }
}