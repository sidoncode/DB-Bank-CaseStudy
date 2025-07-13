package com.DBBank.trade.reconciliation.Reconciliation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReconciliationDifferenceRepository extends JpaRepository<ReconciliationDifference, Long> {

    @Query("SELECT MAX(rd.reconciliationRun.id) FROM ReconciliationDifference rd")
    Long findMaxReconciliationRunId();

    List<ReconciliationDifference> findByReconciliationRunId(Long runId);

}