package com.vther.proxy.demo._02_jdk_proxy;

import com.vther.proxy.demo._00_common.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler {

    private static final Logger LOG = LoggerFactory.getLogger(JDKProxy.class);

    private OrderService target;

    public JDKProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        LOG.info("JDKProxy cost time = {}, methodName={}", System.currentTimeMillis() - start, method.getName());
        return result;
    }
}
