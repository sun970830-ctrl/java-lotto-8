package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView in = new InputView();
        OutputView out = new OutputView();

        Money money = readMoney(in, out);
        LottoSeller seller = new LottoSeller(new MissionUtilsNumbersPicker());
        List<Lotto> tickets = seller.sell(money);
        out.printTickets(tickets);

        WinNumbers winning = readWinning(in, out);
        BounsNumber bonus = readBonus(in, out, winning);

        LottoMatcher matcher = new LottoMatcher();
        Statistics stats = matcher.matchAll(tickets, winning.lotto(), bonus);
        out.printStatistics(stats, stats.yieldPercent(money));
    }

    private static Money readMoney(InputView in, OutputView out) {
        try { return new Money(in.readPurchaseAmount()); }
        catch (IllegalArgumentException e) {
            out.printError(e.getMessage());
            return readMoney(in, out); // 해당 입력만 재시도
        }
    }

    private static WinNumbers readWinning(InputView in, OutputView out) {
        try { return new WinNumbers(in.readWinningNumbers()); }
        catch (IllegalArgumentException e) {
            out.printError(e.getMessage());
            return readWinning(in, out);
        }
    }

    private static BounsNumber readBonus(InputView in, OutputView out, WinNumbers winning) {
        try { return new BounsNumber(winning.lotto(), in.readBonusNumber()); }
        catch (IllegalArgumentException e) {
            out.printError(e.getMessage());
            return readBonus(in, out, winning);
        }

    }
}
