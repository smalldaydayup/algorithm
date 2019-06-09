package spring.aop.myDynamic;

public class Duck implements Animal {
    @Override
    public void sing() {
        System.out.println("my is duck, im gagagag");
    }

    @Override
    public void song() {
        System.out.println("duck is song, im gagagag");
    }
}
