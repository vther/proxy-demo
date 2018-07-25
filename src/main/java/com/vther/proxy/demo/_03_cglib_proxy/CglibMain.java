package com.vther.proxy.demo._03_cglib_proxy;

import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.service.impl.OrderServiceImpl;

public class CglibMain {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        CglibProxy cglibProxy = new CglibProxy();
        OrderServiceImpl orderService = (OrderServiceImpl) cglibProxy.getProxy(OrderServiceImpl.class);
        orderService.create(new Order());
        orderService.update(new Order());
        System.out.println("----------------------------------------------------");
    }
}


