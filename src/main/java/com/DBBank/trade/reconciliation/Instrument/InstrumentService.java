package com.DBBank.trade.reconciliation.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Cacheable(value = "instruments", key = "#symbol")
    public Instrument getInstrument(String symbol) {
        return instrumentRepository.findById(symbol).orElse(null);
    }

    public  List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @CacheEvict(value = "instruments", allEntries = true)
    public void reloadCache() {
        // This just evicts, cache will be reloaded on demand.
    }
}
