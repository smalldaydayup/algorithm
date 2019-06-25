package spring.aop.myDynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Man m = new Man();
        InvocationHandler pro = new HumanProxy(m);

        Class<?> cls = m.getClass();
        Human pd = (Human) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), cls.getInterfaces(), pro);
        pd.say();

    }
}
