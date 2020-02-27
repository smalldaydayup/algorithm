package sword;

import java.util.Stack;

public class ReversePrint {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node root = newList(arr);
//        reversePrint(root);
        reversePrintByStack(root);
    }

    public static void reversePrint(Node head) {
        if (head == null) return;
        reversePrint(head.next);
        System.out.println(head.value);
    }

    public static void reversePrintByStack(Node head) {
        Stack<Integer> stc = new Stack<>();
        Node cur = head;
        while(cur != null) {
            stc.push(cur.value);
            cur = cur.next;
        }

        while (!stc.empty()) {
            System.out.println(stc.pop());
        }
    }

    public static Node newList(int[] arr) {
        if(arr.length < 1) return null;
        Node head = new Node(arr[0], null);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node obj = new Node(arr[i], null);
            cur.next = obj;
            cur = cur.next;
        }

        return head;
    }
}

class Node {
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    int value;
    Node next;
}
