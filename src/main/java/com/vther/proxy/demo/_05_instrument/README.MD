目前字节码修改技术有ASM，javassist等。cglib就是基于封装的Asm. 

ASM 是一个 Java 字节码操控框架。它能够以二进制形式修改已有类或者动态生成类。ASM 可以直接产生二进制 class 文件，也可以在类被加载入 Java 虚拟机之前动态改变类行为。ASM 从类文件中读入信息后，能够改变类行为，分析类信息，甚至能够根据用户要求生成新类。
不过ASM在创建class字节码的过程中，操纵的级别是底层JVM的汇编指令级别，这要求ASM使用者要对class组织结构和JVM汇编指令有一定的了解。

Java字节码生成开源框架介绍--Javassist：

Javassist是一个开源的分析、编辑和创建Java字节码的类库。是由东京工业大学的数学和计算机科学系的 Shigeru Chiba （千叶 滋）所创建的。它已加入了开放源代码JBoss 应用服务器项目,通过使用Javassist对字节码操作为JBoss实现动态AOP框架。javassist是jboss的一个子项目，其主要的优点，在于简单，而且快速。直接使用java编码的形式，而不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。


```
一：IDEA导出jar
1,Project Structure
2,Artifacts
3,改输出名
4,OutPut LayOut -- + -- Module Output
5,Create Manifest File
6,写入Register
7,Bulid -- Build Artifacts
二：运行javaagent
VM参数加上：-javaagent:D:\instrument-demo\out\artifacts\instrument_demo\instrument-demo.jar
```

[利用ClassFileTransformer实现aop](http://xj84.iteye.com/blog/1221105)
[Java Instrument动态修改字节码入门-添加方法耗时监控](https://blog.csdn.net/tterminator/article/details/54381618)
