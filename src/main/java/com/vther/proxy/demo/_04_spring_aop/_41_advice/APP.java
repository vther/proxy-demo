package com.vther.proxy.demo._04_spring_aop._41_advice;

import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.service.OrderService;
import com.vther.proxy.demo._00_common.service.impl.OrderServiceImpl;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class APP {
    public static void main(String[] args) {
        _41_advice();

    }

    private static void _41_advice() {
        BeforeAdvice logBeforeAdvice = new LogBeforeAdvice();

        OrderService target = new OrderServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(logBeforeAdvice);
        proxyFactory.setOptimize(true);
        // use jdk proxy
        // proxyFactory.setInterfaces(target.getClass().getInterfaces());
        // use cglib proxy
        // proxyFactory.setOptimize(true);

        // 此处进去看源码
        OrderService orderService = (OrderService) proxyFactory.getProxy();
        orderService.create(new Order());
    }
}


