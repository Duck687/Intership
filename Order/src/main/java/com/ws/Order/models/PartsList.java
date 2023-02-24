package com.ws.Order.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class PartsList {
    @Id
    private Long orderId;
    private Long partId;
    public PartsList() {

    }

    public PartsList(Long orderId, Long partId) {
        this.orderId = orderId;
        this.partId = partId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }
}
