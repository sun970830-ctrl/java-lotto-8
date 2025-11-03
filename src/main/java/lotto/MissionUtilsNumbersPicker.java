package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MissionUtilsNumbersPicker implements NumbersPicker {
    @Override
    public List<Integer> pick() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().toList();
    }
}