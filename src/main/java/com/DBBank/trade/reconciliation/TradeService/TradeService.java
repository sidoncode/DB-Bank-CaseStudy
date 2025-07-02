package com.DBBank.trade.reconciliation.TradeService;

import com.DBBank.trade.reconciliation.Trade.Trade;
import com.DBBank.trade.reconciliation.TradeRepo.TradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepo tradeRepository;

    // ✅ Caches all trades list with key "all"
    @Cacheable(value = "tradeCache", key = "'all'")
    public List<Trade> getAllTrades() {
        System.out.println("⛏️ Fetching all trades from DB");
        return tradeRepository.findAll();
    }

    // ✅ Caches individual trade by ID
    @Cacheable(value = "tradeCache", key = "#id")
    public Trade getTrade(Long id) {
        System.out.println("⛏️ Fetching trade ID " + id + " from DB");
        return tradeRepository.findById(id).orElse(null);
    }

    // ✅ Puts new/updated trade in cache
    @CachePut(value = "tradeCache", key = "#trade.id")
    public Trade createTrade(Trade trade) {
        System.out.println("💾 Saving trade and updating cache for ID " + trade.getId());
        return tradeRepository.save(trade);
    }

    // ✅ Evicts deleted trade + "all" cache
    @CacheEvict(value = "tradeCache", key = "#id")
    public void deleteTrade(Long id) {
        System.out.println("🗑️ Deleting trade ID " + id + " and evicting cache");
        tradeRepository.deleteById(id);
        evictAllTradesCache(); // optional
    }

    // ✅ Clear the "all" cache
    @CacheEvict(value = "tradeCache", key = "'all'")
    public void evictAllTradesCache() {
        System.out.println("🧹 Evicting 'all' trades cache");
    }
}