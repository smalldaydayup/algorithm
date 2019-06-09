package spring.aop.myDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DuckProxy implements InvocationHandler {
    private Object obj;

    public DuckProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(this.obj, args);
        System.out.println("after");
        return null;
    }
}
