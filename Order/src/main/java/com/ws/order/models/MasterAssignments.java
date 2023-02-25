package com.ws.order.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MasterAssignments {
    @Id
    private Long orderId;
    private Long accountId;

    public MasterAssignments() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public MasterAssignments(Long orderId, Long accountId) {
        this.orderId = orderId;
        this.accountId = accountId;
    }
}
