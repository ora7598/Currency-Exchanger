package com.jb.currencyexchanger.task;

import com.jb.currencyexchanger.model.ExchangesHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DailyUpdateHistoryCurrencyRates {
    private static final int TRIGGER_TASK_EVERY_MINMUTES = 1000 * 60 * 60 * 24;
    private final ExchangesHistory exchangesHistory;

    @Scheduled(fixedRate = TRIGGER_TASK_EVERY_MINMUTES)
    public void updateHistoryExchanges() {
        exchangesHistory.resetHistorySet();
    }
}
