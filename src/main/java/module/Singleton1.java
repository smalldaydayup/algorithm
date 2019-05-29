package module;

public class Singleton1 {
    private static class holder {
        private static final Singleton1 singleton1 = new Singleton1();
    }

    private Singleton1() {};

    public static Singleton1 getInstance() {
        return holder.singleton1;
    }

}
