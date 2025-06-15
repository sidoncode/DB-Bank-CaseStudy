package com.DBBank.trade.reconciliation.TradeController;

import com.DBBank.trade.reconciliation.Trade.Trade;
import com.DBBank.trade.reconciliation.TradeService.TradeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
@Data
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping
    public List<Trade> getAll() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> get(@PathVariable Long id) {
        Trade t = tradeService.getTrade(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Trade create(@RequestBody Trade trade) {
        return tradeService.createTrade(trade);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tradeService.deleteTrade(id);
    }
}

