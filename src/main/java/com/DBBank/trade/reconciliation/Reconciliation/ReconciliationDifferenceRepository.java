package com.DBBank.trade.reconciliation.Reconciliation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReconciliationDifferenceRepository extends JpaRepository<ReconciliationDifference, Long> {
    List<ReconciliationDifference> findByReconciliationRunId(Long runId);
}