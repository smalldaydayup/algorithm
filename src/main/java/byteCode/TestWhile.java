package byteCode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestWhile {
    public void sing(int i, String s) {
        while (i != 10){
            System.out.println("i");
            i++;
        }
    }

    public int sing(int i) {
        System.out.println(i);
        return i;
    }

    public void song(int i) {
        if (i != 10) {
            System.out.println("i");
            i++;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestWhile testWhile = new TestWhile();

        Class<?> clazz = Class.forName("byteCode.TestWhile");


        Integer i = new Integer(10);
        Class<?> cls = i.getClass();
        Class[] cArg = new Class[1];
        cArg[0] = int.class;
        Method method = clazz.getDeclaredMethod("sing", int.class, "sd".getClass());

        Object[] bArg = new Object[2];
        bArg[0] = 1;
        bArg[1] = "wudu";
        method.invoke(testWhile, 1, "wudu");
//        Method[] meth = clazz.getDeclaredMethods();
//        meth[1].invoke(testWhile, 10);
    }
}
