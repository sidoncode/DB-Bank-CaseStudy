package com.DBBank.trade.reconciliation.Reconciliation;

import jakarta.persistence.*;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReconciliationDifference {


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValueSystemA() {
        return valueSystemA;
    }

    public void setValueSystemA(String valueSystemA) {
        this.valueSystemA = valueSystemA;
    }

    public String getValueSystemB() {
        return valueSystemB;
    }

    public void setValueSystemB(String valueSystemB) {
        this.valueSystemB = valueSystemB;
    }

    public ReconciliationRun getReconciliationRun() {
        return reconciliationRun;
    }

    public void setReconciliationRun(ReconciliationRun reconciliationRun) {
        this.reconciliationRun = reconciliationRun;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradeId;
    private String fieldName;
    @Column(name = "value_system_a")
    private String valueSystemA;
    @Column(name = "value_system_b")
    private String valueSystemB;

    @ManyToOne
    @JoinColumn(name = "reconciliation_run_id")
    private ReconciliationRun reconciliationRun;
}
