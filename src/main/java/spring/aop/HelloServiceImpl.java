package spring.aop;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHelloworld() {
        System.out.println("hello world!");
    }
}
