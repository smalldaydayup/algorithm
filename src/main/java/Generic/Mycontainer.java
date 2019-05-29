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
        Mycontainer<Animal> ss = new Mycontainer<>(animal);
        ss.t.say();


    }
}
