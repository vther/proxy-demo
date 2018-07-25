package com.vther.proxy.demo._04_spring_aop._41_advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class LogMethodAdvice implements MethodInterceptor ,Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(LogMethodAdvice.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LOG.info("LogMethodAdvice start.....");
        Object proceed = invocation.proceed();
        LOG.info("LogMethodAdvice end.....");
        return proceed;
    }
}
