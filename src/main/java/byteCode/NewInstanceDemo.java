package byteCode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstanceDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c2 = String.class;
        Constructor constructor = c2.getConstructor(String.class);

        String s = (String) constructor.newInstance("string");

        System.out.println(s);
    }
}
