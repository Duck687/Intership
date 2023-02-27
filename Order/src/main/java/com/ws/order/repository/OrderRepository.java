package com.ws.order.repository;

import com.ws.order.models.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Long> {
}
