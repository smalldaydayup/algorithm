package module;

import sun.tools.tree.SynchronizedStatement;

public class Singleton {
    private volatile static Singleton singleton;

    public Singleton() {};

    public static Singleton getSingleton() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
