package com.ws.Order.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AdministratorAssignments {
    @Id
    private Long orderId;
    private Long accountId;

    public AdministratorAssignments() {
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

    public AdministratorAssignments(Long orderId, Long accountId) {
        this.orderId = orderId;
        this.accountId = accountId;
    }
}
