package concurrentT;

public class MyVolatile {
    private static volatile MyVolatile myVolatile;

    MyVolatile() {}

    public static MyVolatile getMyVolatile() {
        if (myVolatile == null) {
            synchronized (MyVolatile.class) {
                if (myVolatile == null) {
                    myVolatile = new MyVolatile();
                }
            }

        }
        return myVolatile;
    }
}
