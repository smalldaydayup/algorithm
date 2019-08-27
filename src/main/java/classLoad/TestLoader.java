package classLoad;

import utils.Node;

public class TestLoader {
    public static void main(String[] args) {
        Class klass = Node.class;

        ClassLoader loader = klass.getClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
