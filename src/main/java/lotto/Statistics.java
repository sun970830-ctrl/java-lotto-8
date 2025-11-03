package lotto;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public Statistics() {
        for (Rank r : Rank.values()) counts.put(r, 0);
    }

    public void add(Rank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    public int count(Rank rank) { return counts.get(rank); }

    public long totalPrize() {
        long sum = 0;
        for (Rank r : Rank.values()) sum += (long) r.prize() * counts.get(r);
        return sum;
    }

    public double yieldPercent(Money spent) {
        double y = (double) totalPrize() / spent.amount() * 100.0;
        return Math.round(y * 10.0) / 10.0; // 소수점 둘째 반올림 → 한 자리 표시
    }
}