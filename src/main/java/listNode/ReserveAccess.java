package listNode;

import java.util.*;

public class ReserveAccess {
    public static volatile int race = 0;

    public static void main(String[] args) {
        List<Character> list = new LinkedList<>();
        list.add('b');
        Character character = new Character('b');

        char[] suc = new char[]{'0', '0', '0'};
        System.out.println(String.valueOf(suc));


        StringBuilder sb = new StringBuilder("c");
        sb.insert(1, 'b');
        System.out.println(sb.toString());


        HashMap<Character, Integer> map1 = new HashMap<>();
        map1.put('c', 1);
        Integer t = map1.get('d');
        System.out.println(t);


        Scanner sc = new Scanner(System.in);

        int[] a  = {2,3,5};
        int[] b = new int[3];

        Stack<Integer> st = new Stack<Integer>();

        for (int i: a) {
            st.push(i);
        }

        for (int i = 0; i < a.length ; i++) {
            b[i] = st.pop();
            System.out.println(b[i]);
        }

        System.out.println(b);
        run();

    }

    public static void run() {

        for (int i = 0; i < 10; i++) {
           Thread t1 = new Thread(new Runnable() {
               @Override
               public void run() {
                   for (int j = 0; j < 10; j++) {
                       System.out.println(race);
                       race ++;

                   }
               }
           });
           t1.start();
        }

        while (Thread.activeCount() < 1) Thread.yield();

        System.out.println(race);
    }


}
