package com.ws.Order.service;

import com.ws.Order.models.Orders;
import com.ws.Order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Orders> getAllOrder() {
        return (List<Orders>) orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    public void saveOrUpdateOrder(Orders account) {
        orderRepository.save(account);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
