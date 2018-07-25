package com.vther.proxy.demo._04_spring_aop._42_proxy_factory_bean;

import com.vther.proxy.demo._00_common.service.OrderService;
import com.vther.proxy.demo._00_common.service.impl.OrderServiceImpl;
import com.vther.proxy.demo._04_spring_aop._41_advice.LogMethodAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringProxyConfig {

    @Bean
    public OrderService target() {
        return new OrderServiceImpl();
    }

    @Bean
    public MethodInterceptor logMethodAdvice() {
        return new LogMethodAdvice();
    }

    @Bean
    public ProxyFactoryBean orderService() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(target());
//        proxyFactoryBean.setTarget(new OrderServiceImpl());
        proxyFactoryBean.setInterceptorNames("logMethodAdvice");
        return proxyFactoryBean;
    }

}
