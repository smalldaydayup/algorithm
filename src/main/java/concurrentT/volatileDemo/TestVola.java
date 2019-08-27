package concurrentT.volatileDemo;

public class TestVola {
    private static  TestVola myVolatile;

    private TestVola() {}

    public int getV(int i) {
        return 1;
    }

    public void getV(int i, int j) {

    }

    public static TestVola getMyVolatile() {
        if (myVolatile == null) {
            return myVolatile = new TestVola();
        }
        return myVolatile;
    }
}
