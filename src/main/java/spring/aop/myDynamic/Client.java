package spring.aop.myDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Duck d = new Duck();
        InvocationHandler dp = new DuckProxy(d);

        Class<?>  cls = d.getClass();
        Animal pd = (Animal) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), cls.getInterfaces(), dp);

        pd.sing();
        pd.song();
    }

}
