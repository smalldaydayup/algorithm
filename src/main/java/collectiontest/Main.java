package collectiontest;

public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr1 = new int[]{1,2,3,4,5, 10, 17, 20};
        int[] arr2 = new int[]{7,8,9,10,11,12, 19};
        Node h1 = buildNode(arr1);
        Node h2 = buildNode(arr2);

        Node h = merge(h1, h2);
        Node cur = h;
        while (cur != null) {
            System.out.print(cur.value);
            System.out.print(" ");
            cur = cur.next;
        }
    }

    public static Node buildNode(int[] arr) {
        if (arr.length  == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node cur = head;
        for(int i = 1; i< arr.length; i++){
            Node tmp = new Node(arr[i]);
            cur.next = tmp;
            cur = cur.next;
        }

        return head;
    }

    public static Node merge(Node h1, Node h2) {
        Node p = h1;
        Node q = h2;
        Node root = new Node(0);
        Node cur = root;
        while(p !=null && q != null) {
            if (q.value > p.value) {
                cur.next = p;
                p = p.next;
            }else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }

        return root.next;
    }


}

class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
    }
}
