package com.vther.proxy.demo._03_cglib_proxy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(CglibProxy.class);

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(obj, args);
        LOG.info("CglibProxy cost time = {}, methodName={}", System.currentTimeMillis() - start, method.getName());
        return result;
    }
}
