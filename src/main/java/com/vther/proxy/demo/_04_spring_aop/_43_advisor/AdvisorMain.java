package com.vther.proxy.demo._04_spring_aop._43_advisor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorMain {

    public static void main(String[] args) {
        staticMethod();
        regexp();
    }

    public static void staticMethod() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/vther/proxy/demo/advisor/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    public static void regexp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/vther/proxy/demo/advisor/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }


}
