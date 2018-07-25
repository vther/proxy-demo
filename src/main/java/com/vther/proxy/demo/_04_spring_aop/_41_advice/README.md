# SpringAOP基础
## AOP 术语
### 1.连接点(Joinpoint)
特定点是程序执行的某个特定位置，如类开始初始化前、类初始化后、类的某个方法调用前/调用后，方法抛出异常后。一个类或一段程序代码拥有一些具有边界性质的特定点，这些代在中的特定点就被称为“连接点”。Spring 仅支持方法的连接点，即仅能在方法调用前、方法调用后、方法抛出异常时及方法调用前后这些程序执行点织入增强。

我们知道，黑客攻击系统需要找到突破口，没有突破口就无法进行攻击。从某种程度上来说，AOP 也可以看成一个黑客(因为它要向目前类中嵌入额外的代码逻辑)，连接点就是AOP向目标类打入楔子的候选锚点。

连接点由两个信息确定:一是用方法表示的程序执行点;二是用相对位置表示的方位。如在Test.foo()方法执行前的连接点，执行点为Test.foo(),方位为该方法执行前的位置。Spring使用切点对执行点进行定位，而方位则在增强类型中定义。
### 2.切点(Pointcut)
每个程序类都拥有多个连接点，如一个拥有两个方法的类,这两个方法都是连接点，即连接点是程序类中客观存在的事物。但在为数众多的连接点中，如何定位某些感兴趣的连接点呢? AOP通过“切点”定位特定的接连点借助数据库查询的概念来理解切点和连接点的关系再合适不过了: **连接点相当于数据库中的记录，而切点相当于查询条件**。切点和连接点不是一对一的关系，一个切点可以匹配多个连接点。

在Spring 中，切点通过org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条件，SpringAOP的规则解析引擎负责解析切点所设定的查询条件，找到对应的连接点。确切地说，应该是执行点而非连接点，因为连接点是方法执行前、执行后等包括方位信息的具体程序执行点，而切点只定位到某个方法上，所以如果希望定位到具体的连接点上，还需要提供方位信息。
### 3.增强(Advice)
增强是织入目标类连接点上的一段程序代码，是不是觉得AOP 越来越像黑客了，这不是往业务类中装入木马吗?我们大可按照这一思路去理解增强，因为这样更形象易懂。在Spring中,增强除用于描述一段程序代码外，还拥有另一个和连接点相关的信息，这便是执行点的方位。结合执行点的方位信息和切点信息，就可以找到特定的连接。正因为增强既包含用于添加到目标连接点上的一段执行逻辑，又包含用于定位连接点的方位信息，所以Spring 所提供的增强接口都是带方位名的，如BeforeAdvice、AfterReturningAdvice、ThrowsAdvice 等。BeforeAdvice 表示方法调用前的位置，而AfterReturingAdvice 表示访问返回后的位置。所以只有结合切点和增强，才能确定特定的连接点并实施增强逻辑。

有很多书籍和文章将Advice 译为“通知”，就像將“how old are you?”译为“怎么老是你”一样，明显是一种“望文生义”的译法。来看几个使用“通知”的语境: 银行向张三三发出了一个催款通知;班主任通知学生明天大扫除。从这些语境中可以知道，通知者只是把某个消息传达给被通知者，并不会替被通知者做任何事情。而Spring 的Advice 必须嵌入类的某连接点上，并完成一段附加的执行逻辑，这明显是去“增强”目标类的功能。当然，我们不能对这个翻译有过多的微词，毕竟Advice 这个英文单词本身就有些不知所云，如果将其改为Enhancer,相信理解起来会更容易一些。
通知的类型：

1、前置通知（Before advice）：在某连接点（join point）之前执行的通知，但这个通知不能阻止连接点前的执行（除非它抛出一个异常）。
2、返回后通知（After returning advice）：在某连接点（join point）正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。
3、抛出异常后通知（After throwing advice）： 在方法抛出异常退出时执行的通知。
4、后通知（After (finally) advice）： 当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
5、环绕通知（Around Advice）： 包围一个连接点（join point）的通知，如方法调用。这是最强大的一种通知类型。 环绕通知可以在方法调用前后完成自定义的行为。它也会选择是否继续执行连接点或直接返回它们自己的返回值或抛出异常来结束执行。

### 4.目标对象(Target)
增强逻辑的织入目标类。如果没有AOP,那么目标业务类需要自己实现所有的逻辑，就如代码清单7-1中的ForumService 所示。在AOP 的帮助下，ForumService 只实现那些非横切逻辑的程序逻辑，而性能监视和事务管理等这些横切逻辑则可以使用AOP 动态织入特定的连接点上。
### 5.引介(Introduction)
引介是一种特殊的增强，它为类添加一些属性和方法。这样，即使一个业务类原本没有实现某个接口，通过AOP 的引介功能，也可以动态地为该业务类添加接口的实现逻辑，让业务类成为这个接口的实现类。
### 6.织入(Weaving)
织入是将增强添加到月标类的具体连接点上的过程。AOP 就像一台织布机，将目标类、增强或者引介天衣无缝地编织到一起。我们不能不说“织入”这个词太精辟了。根据不同的实现技术，AOP 有3 种织入方式。
1. 编译期织入，这要求使用特殊的Java 编译器。
2. 类装载期织入，这要求使用特殊的类装载器。(LoadTimeWeaving)
3. 动态代理织入，在运行期为目标类添加增强生成子类的方式。

Spring 采用动态代理织入，而AspectJ 采用编译期织入和类装载期织入。
### 7.代理(Proxy)
一个类被AOP织入增强后，就产生了一个结果类，它是融合了原类和增强逻辑的代理类。根据不同的代理方式，代理类既可能是和原类具有相同接口的类，也可能就是原类的子类，所以可以采用与调用原类相同的方式调用代理类。
### 8.切面(Aspect)
切面由切点(Pointcut)和增强(Advice)组成，它既包括横切逻辑的定义，也包括连接点的定义。SpringAOP 就是负责实施切面的框架，它将切面所定义的横切逻辑织入切面所指定的连接点中。AOP 的工作重心在于如何将增强应用于目标对象的连接点上。这里包括两项工作:第一，如何通过切点和增强定位到连接点上; 第二，如何在增强中编写切面的代码。本章大部分内容都将围绕这两点展开。



## AOP 的实现者
AOP 工具的设计目标是把横切的问题(如性能监视、事务管理)模块化。使用类似OOP的方式进行切面的编程工作。位于AOP工具核心的是连接点模型，它提供了一种机制，可以定位到需要在哪里发生横切。
### I.AspectJ
AspectJ 是语言级的AOP 实现，2001年由Xerox PARC 的AOP小组发布，目前版本已经更新到1.8.9。AspectJ 扩展了Java 语言，定义了AOP 语法，能够在编译期提供横切代码的织入，所以它有一个专门的编译器用来生成遵守Java 字节编码规范的Class文件。其主页位于http://www.eclipse.org/aspectj。
### 2.AspectWerkz
AspectWerkz 是基于Java 的简单、动态、轻量级的AOP框架，该框架于2002 年发布，由BEA Systems 提供支持。它支持运行期或类装载期织入横切代码，所以它拥有一个特殊的类装载器。现在，AspectJ 和AspectWerkz项目已经合并，以便整合二者的力量和技术创建统一的AOP平台。它们合作的第一个发布版本是AspectJ 5; 扩展AspectJ语言，以基于注解的方式支持类似AspectJ 的代码风格。
### 3.JBOSS AOP
JBOSSAOP 于2004 年作为JBOSS应用程序服务器框架的扩展功能发布，读者可以从以下地址了解至JBOSS AOP 的更多信息:htp://wwwjboss.org/products/aop.
### 4.Spring AOP 
使用纯Java 实现，它不需要专门的编译过程，也不需要特殊的类装载器，它在运行期通过代理方式向目标类织入增强代码。Spring 并不尝试提供最完整的AOP 实现，相反，它侧重于提供一种和Spring IoC 容器整合的AOP 实现，用以解决企业级开发中的常见问题。在Spring 中可以无缝地将Spring AOP、IOC 和AspectJ 整合在一起。

## AOP联盟

org.aopalliance.aop.Advice
&emsp;&emsp;org.springframework.aop.AfterReturningAdvice
&emsp;&emsp;org.springframework.aop.BeforeAdvice
&emsp;&emsp;&emsp;&emsp;org.springframework.aop.MethodBeforeAdvice
&emsp;&emsp;org.springframework.aop.DynamicIntroductionAdvice
&emsp;&emsp;org.springframework.aop.IntroductionInterceptor (also extends org.aopalliance.intercept.MethodInterceptor)
&emsp;&emsp;org.aopalliance.intercept.Interceptor
&emsp;&emsp;org.aopalliance.intercept.MethodInterceptor
&emsp;&emsp;&emsp;&emsp;org.springframework.aop.IntroductionInterceptor (also extends org.springframework.aop.DynamicIntroductionAdvice)
&emsp;&emsp;org.springframework.aop.ThrowsAdvice