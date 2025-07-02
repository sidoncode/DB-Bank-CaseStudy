package com.DBBank.trade.reconciliation.Reconciliation;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/reconciliation")
public class ReconciliationController {

    private final ReconciliationService reconciliationService;

    public ReconciliationController(ReconciliationService reconciliationService) {
        this.reconciliationService = reconciliationService;
    }

    // Start reconciliation
    @PostMapping("/start")
    public ResponseEntity<Long> startReconciliation() {
        Long runId = reconciliationService.startReconciliation();
        return ResponseEntity.ok(runId);
    }

    // ✅ New: Get all differences (from latest run or all)
    @GetMapping("/differences")
    public ResponseEntity<List<ReconciliationDifference>> getAllDifferences() {
        return ResponseEntity.ok(reconciliationService.getAllDifferences());
    }

    // Optional: if you want to fetch by specific run ID
    @GetMapping("/differences/{runId}")
    public ResponseEntity<List<ReconciliationDifference>> getDifferencesByRun(@PathVariable Long runId) {
        return ResponseEntity.ok(reconciliationService.getDifferences(runId));
    }
}
