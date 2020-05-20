package company.byteDancer.listWithTree;

public class ReverseList {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode h = build(arr);

        ListNode reverseH = reverseList(h);
        ListNode cur = reverseH;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = p.next;
        p.next = null;

        while (p != null && q != null) {
            ListNode e = q.next;
            q.next = p;
            p = q;
            q = e;
        }

        return p;
    }

    public static ListNode build(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }


}
