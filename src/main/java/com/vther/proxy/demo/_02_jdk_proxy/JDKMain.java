package com.vther.proxy.demo._02_jdk_proxy;

import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.service.OrderService;
import com.vther.proxy.demo._00_common.service.impl.OrderServiceImpl;

import java.lang.reflect.Proxy;

public class JDKMain {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        OrderService target = new OrderServiceImpl();
        JDKProxy jdkProxy = new JDKProxy(target);
        OrderService orderService = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), jdkProxy);
        orderService.create(new Order());
        orderService.update(new Order());
        System.out.println("----------------------------------------------------");
    }
}


