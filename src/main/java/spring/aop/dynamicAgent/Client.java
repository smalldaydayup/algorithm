package spring.aop.dynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);

        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), cls.getInterfaces(), ds);

        subject.request();
        System.out.println(subject.getClass());
    }
}
