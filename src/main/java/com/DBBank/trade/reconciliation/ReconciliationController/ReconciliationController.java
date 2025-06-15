package com.DBBank.trade.reconciliation.ReconciliationController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reconciliation")
public class ReconciliationController {

    @PostMapping("/start")
    public ResponseEntity<String> startReconciliation() {
        // Simulated job
        return ResponseEntity.ok("Reconciliation started.");
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<String> getStatus(@PathVariable Long id) {
        // Stub response
        return ResponseEntity.ok("Completed");
    }

    @GetMapping("/differences")
    public List<String> getUnmatchedTrades() {
        return List.of("Trade123", "Trade456");
    }
}

