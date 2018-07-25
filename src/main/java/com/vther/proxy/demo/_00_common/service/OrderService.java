package com.vther.proxy.demo._00_common.service;

import com.vther.proxy.demo._00_common.domain.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);

    void update(Order order);

    void batchCreate(List<Order> orders);
}
