package com.vther.proxy.demo._04_spring_aop._41_advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeAdvice implements MethodBeforeAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(LogBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        LOG.info("LogBeforeAdvice before...");
    }
}
