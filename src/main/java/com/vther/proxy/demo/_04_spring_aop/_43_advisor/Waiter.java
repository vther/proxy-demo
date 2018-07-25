package com.vther.proxy.demo._04_spring_aop._43_advisor;


//import org.springframework.aop.framework.AopContext;

public class Waiter {

    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
    }

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void greet2To(String name) {
        System.out.println("waiter serving2 " + name + "...");
        // 内部调用无法被增强，相当于this.greetTo 其实是调用是原类的greetTo方法
        // greetTo(name);
//         ((Waiter)AopContext.currentProxy()).greetTo(name);
//        greetTo(name);
    }
}
