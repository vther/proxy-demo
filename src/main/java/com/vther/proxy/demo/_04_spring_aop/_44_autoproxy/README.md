自动代理

注意1：内部调用无法被增强，相当于this.greetTo 其实是调用是原类的greetTo方法
可以使用该方法1：
```java
((Waiter)org.springframework.aop.framework.AopContext.currentProxy()).greetTo(name);
```

需要配置

```xml
<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"
      p:proxyTargetClass="true" p:exposeProxy="true"/>
```

方法2：
本类中注入ApplicationContext
使用ApplicationContext#getBean方法

本质上就是要用代理类，而不是被代理类