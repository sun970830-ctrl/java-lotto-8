package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return toInt(Console.readLine().trim());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String line = Console.readLine().trim();
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(this::toInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return toInt(Console.readLine().trim());
    }

    private int toInt(String s) {
        try { return Integer.parseInt(s); }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}