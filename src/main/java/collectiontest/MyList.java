package collectiontest;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyList {
    ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int a = 'a' - '0';
        boolean is = 'a' < 'b';
        System.out.println(is);
        System.out.println(a);
        System.out.println(5 /6);

        MyList list = new MyList();
        list.arrayList.add("liu");
        list.arrayList.add("zhang");
        System.out.println(list.arrayList.toString());

        HashSet<String> set = new HashSet<>();
        set.add("liu");
        set.add("liu");
        System.out.println(set.toString());

        LinkedList<String> list1 = new LinkedList();
        list1.add("liu");
        String[] array = new String[list1.size()];
        list1.toArray(array);
        System.out.println(array[0]);

        ClassLoader loader = MyList.class.getClassLoader();
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());


        ConcurrentHashMap<String, String> chash = new ConcurrentHashMap();
        HashMap<String, String> hash = new HashMap<>();
        AtomicInteger ai = new AtomicInteger(0);

        Vector v = new Vector();


        ReentrantLock lock = new ReentrantLock();



        testthreadPool();
    }

    public void getValue(int i) {}

    public int getValue(int i, int y) { return 1; }


    public static void testLinkedHashmap() {
        LinkedHashMap<String, String> llist = new LinkedHashMap<>();

    }

    public static void testthreadPool() {
        ExecutorService ss = Executors.newCachedThreadPool();
         Unsafe unsafe = Unsafe.getUnsafe();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("liusongyang");
            }
        };
        ss.execute(t1);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("unnable");
            }
        };
        ss.execute(r1);
    }
}
