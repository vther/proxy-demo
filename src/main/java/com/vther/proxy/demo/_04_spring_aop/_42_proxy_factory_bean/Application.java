package com.vther.proxy.demo._04_spring_aop._42_proxy_factory_bean;

import com.vther.proxy.demo._00_common.domain.Order;
import com.vther.proxy.demo._00_common.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

//        xmlConfigWay();
        javaConfigWay();
    }

    private static void xmlConfigWay() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/vther/proxy/demo/factory/beans.xml");
//        OrderService orderService = context.getBean("orderService", OrderService.class); //NoUniqueBeanDefinitionException
        OrderService orderService = context.getBean(OrderService.class);
        orderService.create(new Order());
    }

    private static void javaConfigWay() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringProxyConfig.class);
        context.refresh();

        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.create(new Order());
    }
}
