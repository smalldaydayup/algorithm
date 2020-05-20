package testClass;

public class Demo {

    int value;
    static int data;

    public  Demo(int value) {
        this.value = value;
    }
    public static void main(String[] args) {
        Demo d = new Demo(2);
        System.out.println(d.value);
    }


    synchronized public int getValue() {
        return value;
    }

    public int getV(){
        synchronized (this) {
            return value;
        }
    }

    public int iadd() {
        value ++;
        return value;
    }

    synchronized public static int getVa() {
        return data;
    }
}
