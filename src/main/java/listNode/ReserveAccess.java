package listNode;

import java.util.Scanner;
import java.util.Stack;

public class ReserveAccess {

    public static void main(String[] args) {
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

    }

}
