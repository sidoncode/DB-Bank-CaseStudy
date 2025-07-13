package com.DBBank.trade.reconciliation.Reconciliation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReconciliationRun {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRunDate() {
        return runDate;
    }

    public void setRunDate(LocalDateTime runDate) {
        this.runDate = runDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public void setMatchedCount(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    public int getUnmatchedCount() {
        return unmatchedCount;
    }

    public void setUnmatchedCount(int unmatchedCount) {
        this.unmatchedCount = unmatchedCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime runDate;

    private String status;

    private int matchedCount;

    private int unmatchedCount;
}