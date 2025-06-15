package com.DBBank.trade.reconciliation.TradeRepo;

import com.DBBank.trade.reconciliation.Trade.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TradeRepo extends JpaRepository<Trade, Long> {
    List<Trade> findByTradeDate(LocalDate date);
}
