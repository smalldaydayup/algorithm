package byteCode;

import java.lang.reflect.Field;
import java.util.List;

public class FieldTest {
    class FieldSpy<T> {
        public Boolean[][] b = {{false, false}, {true, true}};
        public String name = "Alice";
        public List<Integer> list;
        public T val;
    }
    public static void main(String[] args) throws NoSuchFieldException {
        Field f1 = FieldSpy.class.getField("b");
        System.out.format("Type: %s%n", f1.getType());
        Field f2 = FieldSpy.class.getField("name");
        System.out.format("Type: %s%n", f2.getType());
        Field f3 = FieldSpy.class.getField("list");
        System.out.format("Type: %s%n", f3.getType());
        Field f4 = FieldSpy.class.getField("val");
        System.out.format("Type: %s%n", f4.getType());
    }
}