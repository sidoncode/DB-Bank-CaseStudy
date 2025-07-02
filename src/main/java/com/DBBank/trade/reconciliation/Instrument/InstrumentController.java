package com.DBBank.trade.reconciliation.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {


    @Autowired
    private InstrumentService instrumentService;

    @PostMapping("/cache/reload")
    public ResponseEntity<String> reloadCache() {
        // Call caching service
        return ResponseEntity.ok("Cache reloaded");
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Map<String, String>> getInstrument(@PathVariable String symbol) {
        return ResponseEntity.ok(Map.of("symbol", symbol, "name", "Apple Inc."));
    }

    @GetMapping
    public ResponseEntity<List<Instrument>> getAllInstruments() {
        return ResponseEntity.ok(instrumentService.getAllInstruments());
    }

}


