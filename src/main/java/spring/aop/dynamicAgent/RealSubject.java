package spring.aop.dynamicAgent;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("this is real subject");
    }
}
