package com.vther.proxy.demo._01_design_pattern;

import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProxyOrderServiceImpl implements OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(ProxyOrderServiceImpl.class);

    private OrderService orderService;

    public ProxyOrderServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void create(Order order) {
        long start = System.currentTimeMillis();
        orderService.create(order);
        LOG.info("ProxyOrderServiceImpl create cost time = {}", System.currentTimeMillis() - start);
    }

    @Override
    public void update(Order order) {
        orderService.update(order);
    }

    @Override
    public void batchCreate(List<Order> orders) {
        orderService.batchCreate(orders);
    }
}
