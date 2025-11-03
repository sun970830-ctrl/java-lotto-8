package lotto;

import java.util.List;

public class OutputView {

    public void printTickets(List<Lotto> tickets) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", tickets.size());
        for (Lotto t : tickets) {
            System.out.println(t.numbers()); // Lotto가 오름차순 보관
        }
    }

    public void printStatistics(Statistics stats, double yieldPercent) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", stats.count(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", stats.count(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", stats.count(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", stats.count(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", stats.count(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yieldPercent);
    }

    public void printError(String message) {
        System.out.println(message); // [ERROR]로 시작하는 메시지 그대로 출력
    }
}