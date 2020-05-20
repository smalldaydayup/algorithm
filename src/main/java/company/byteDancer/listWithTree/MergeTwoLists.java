package company.byteDancer.listWithTree;

public class MergeTwoLists {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr1 = new int[]{1,2,3,4,5, 10, 17, 20};
        int[] arr2 = new int[]{7,8,9,10,11,12, 19};
        ListNode h1 = buildNode(arr1);
        ListNode h2 = buildNode(arr2);

        ListNode h = merge(h1, h2);
        ListNode cur = h;
        while (cur != null) {
            System.out.print(cur.value);
            System.out.print(" ");
            cur = cur.next;
        }
    }

    public static ListNode buildNode(int[] arr) {
        if (arr.length  == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i< arr.length; i++){
            ListNode tmp = new ListNode(arr[i]);
            cur.next = tmp;
            cur = cur.next;
        }

        return head;
    }

    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode p = h1;
        ListNode q = h2;
        ListNode root = new ListNode(0);
        ListNode cur = root;
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

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}

