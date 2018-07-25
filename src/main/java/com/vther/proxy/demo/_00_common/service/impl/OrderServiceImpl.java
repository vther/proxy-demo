package com.vther.proxy.demo._00_common.service.impl;

import com.vther.proxy.demo._00_common.service.OrderService;
import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public void create(Order order) {
        TimeUtils.sleep(50);
        LOG.info("OrderServiceImpl create");
    }

    @Override
    public void update(Order order) {
        TimeUtils.sleep(100);
        LOG.info("OrderServiceImpl update");
    }

    @Override
    public void batchCreate(List<Order> orders) {
        TimeUtils.sleep(100);
        LOG.info("OrderServiceImpl batchCreate");
    }
}
