package com.DBBank.trade.reconciliation.Reconciliation;


import com.DBBank.trade.reconciliation.Trade.Trade;
import com.DBBank.trade.reconciliation.TradeRepo.TradeRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReconciliationService {

    private final TradeRepo tradeRepo;
    private final ReconciliationRunRepository runRepo;
    private final ReconciliationDifferenceRepository diffRepo;



    // Return all differences
    public List<ReconciliationDifference> getAllDifferences() {
        return diffRepo.findAll();
    }

    public ReconciliationService(TradeRepo tradeRepo,
                                 ReconciliationRunRepository runRepo,
                                 ReconciliationDifferenceRepository diffRepo) {
        this.tradeRepo = tradeRepo;
        this.runRepo = runRepo;
        this.diffRepo = diffRepo;
    }

    public Long startReconciliation() {
        List<Trade> allTrades = tradeRepo.findAll();

        // Group trades by tradeId
        Map<String, List<Trade>> grouped = allTrades.stream()
                .collect(Collectors.groupingBy(Trade::getTradeId));

        int matched = 0, unmatched = 0;
        List<ReconciliationDifference> allDiffs = new ArrayList<>();

        for (Map.Entry<String, List<Trade>> entry : grouped.entrySet()) {
            List<Trade> trades = entry.getValue();

            if (trades.size() > 1) {
                Trade t1 = trades.get(0);
                Trade t2 = trades.get(1); // comparing first two only

                if (!Objects.equals(t1.getPrice(), t2.getPrice())) {
                    ReconciliationDifference diff = new ReconciliationDifference();
                    diff.setTradeId(t1.getTradeId());
                    diff.setFieldName("price");
                    diff.setValueSystemA(String.valueOf(t1.getPrice()));
                    diff.setValueSystemB(String.valueOf(t2.getPrice()));
                    allDiffs.add(diff);
                    unmatched++;
                }

                if (!Objects.equals(t1.getQuantity(), t2.getQuantity())) {
                    ReconciliationDifference diff = new ReconciliationDifference();
                    diff.setTradeId(t1.getTradeId());
                    diff.setFieldName("quantity");
                    diff.setValueSystemA(String.valueOf(t1.getQuantity()));
                    diff.setValueSystemB(String.valueOf(t2.getQuantity()));
                    allDiffs.add(diff);
                    unmatched++;
                }

                if (Objects.equals(t1.getPrice(), t2.getPrice()) &&
                        Objects.equals(t1.getQuantity(), t2.getQuantity())) {
                    matched++;
                }
            }
        }

        // Save reconciliation run
        ReconciliationRun run = new ReconciliationRun();
        run.setRunDate(LocalDateTime.now());
        run.setStatus("COMPLETED");
        run.setMatchedCount(matched);
        run.setUnmatchedCount(unmatched);
        run = runRepo.save(run); // persist and get the ID

        // Link differences with run
        for (ReconciliationDifference diff : allDiffs) {
            diff.setReconciliationRun(run);
        }

        diffRepo.saveAll(allDiffs);
        return run.getId();
    }

    public List<ReconciliationDifference> getDifferences(Long runId) {
        return diffRepo.findByReconciliationRunId(runId);
    }
}
