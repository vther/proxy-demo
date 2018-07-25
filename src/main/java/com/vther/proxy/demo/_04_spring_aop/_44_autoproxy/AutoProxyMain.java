package com.vther.proxy.demo._04_spring_aop._44_autoproxy;

import com.vther.proxy.demo._04_spring_aop._43_advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyMain {
    public static void main(String[] args) {
        String configPath = "com/vther/proxy/demo/autoproxy/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.serveTo("John");
        waiter.greetTo("John");
        //seller.greetTo("Tom");
    }
}
