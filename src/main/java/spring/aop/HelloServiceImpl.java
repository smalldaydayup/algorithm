package spring.aop;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHelloworld() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloService = new HelloServiceImpl();

        Advice beforeAdvice = new BeforeAdvice(helloService, logTask);

        HelloService helloServiceImplProxy = (HelloService) SimpleAop.getProxy(helloService, beforeAdvice);

        helloServiceImplProxy.sayHelloworld();
    }
}
