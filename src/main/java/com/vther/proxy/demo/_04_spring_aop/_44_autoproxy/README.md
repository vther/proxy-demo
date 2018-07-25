自动代理

注意1：内部调用无法被增强，相当于this.greetTo 其实是调用是原类的greetTo方法
可以使用该方法：
```java
((Waiter)org.springframework.aop.framework.AopContext.currentProxy()).greetTo(name);
```

需要配置

```xml
<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"
      p:proxyTargetClass="true" p:exposeProxy="true"/>
```