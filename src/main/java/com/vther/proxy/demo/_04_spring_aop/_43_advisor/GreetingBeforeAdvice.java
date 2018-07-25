package com.vther.proxy.demo._04_spring_aop._43_advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		String clientName = (String)args[0];
		System.out.println(obj.getClass().getName()+"."+method.getName());
		System.out.println("How are you！Mr."+clientName+".");
	}
}
