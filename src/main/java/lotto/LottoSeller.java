package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final NumbersPicker picker;

    public LottoSeller(NumbersPicker picker) {
        this.picker = picker;
    }

    public List<Lotto> sell(Money money) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < money.ticketCount(); i++) {
            tickets.add(new Lotto(picker.pick()));
        }
        return tickets;
    }
}