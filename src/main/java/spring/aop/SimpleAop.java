package spring.aop;

import spring.ioc.SimpleIoc;

import java.lang.reflect.Proxy;

public class SimpleAop {
    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
    }
}
