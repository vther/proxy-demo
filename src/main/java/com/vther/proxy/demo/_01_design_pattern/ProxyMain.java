package com.vther.proxy.demo._01_design_pattern;

import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.service.OrderService;
import com.vther.proxy.demo._00_common.service.impl.OrderServiceImpl;

public class ProxyMain {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        _1_originWay();
        _2_useProxy();
        System.out.println("----------------------------------------------------");
    }


    private static void _1_originWay() {
        OrderService orderService = new OrderServiceImpl();
        orderService.create(new Order());
        orderService.update(new Order());
    }

    private static void _2_useProxy() {
        OrderService orderService = new ProxyOrderServiceImpl(new OrderServiceImpl());
        orderService.create(new Order());
        orderService.update(new Order());
    }
}
