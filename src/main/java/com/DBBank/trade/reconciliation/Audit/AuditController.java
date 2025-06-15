package com.DBBank.trade.reconciliation.Audit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    @GetMapping("/logs")
    public ResponseEntity<List<String>> getLogs() {
        return ResponseEntity.ok(List.of("Audit log 1", "Audit log 2"));
    }

    @GetMapping("/errors/logs")
    public ResponseEntity<List<String>> getErrorLogs() {
        return ResponseEntity.ok(List.of("Error 1", "Error 2"));
    }
}

