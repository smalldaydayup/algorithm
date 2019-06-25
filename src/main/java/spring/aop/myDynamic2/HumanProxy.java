package spring.aop.myDynamic2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanProxy implements InvocationHandler {
    private Object object;

    public HumanProxy(Object o) {
        object = o;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is procy");
        method.invoke(object, args);
        return null;
    }
}
