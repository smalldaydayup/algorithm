package Generic;

import java.util.ArrayList;
import java.util.List;

public class Mycontainer<T extends Animal> {
    T t;

    public  Mycontainer(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Life life = new Life();
        Human human = new Human();
//        Mycontainer<Animal> ss = new Mycontainer<>(animal);
//        ss.t.say();


        Life life1 = new Human();
        life1.say(); 

        int[] arr = new int[]{1,2,3,45};
        for (int i: arr) {
            System.out.println(i);
        }

        ArrayList<String> st = new ArrayList<>();
        st.add("s1");
        st.add("s2");
        st.add("s3");
        st.add("s4");
        st.add("s5");
        st.add("s6");
        st.add("s7");

        Object[] array = st.toArray();
        for (Object i: array) {
            System.out.println(i);
        }

    }
}
