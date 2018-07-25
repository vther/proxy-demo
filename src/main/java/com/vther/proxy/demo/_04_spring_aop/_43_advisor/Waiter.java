package com.vther.proxy.demo._04_spring_aop._43_advisor;


public class Waiter {

    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
        //waiter.greetTo(name);
    }

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }
}
