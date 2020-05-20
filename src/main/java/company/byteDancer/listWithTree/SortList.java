package company.byteDancer.listWithTree;

public class SortList {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,5,3,7,9,0,1};

        ListNode h = ReverseList.build(arr);

        ListNode h1 = sortList(h);
        ListNode cur = h1;

        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static ListNode sortList(ListNode head) {

        //采用快速排序
        quickSort(head, null);
        return head;
    }
    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;

        //走到末尾才停
        while (p2 != end) {

            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.value < head.value) {
                p1 = p1.next;

                int temp = p1.value;
                p1.value = p2.value;
                p2.value = temp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.value;
            p1.value = head.value;
            head.value = temp;
        }
        return p1;
    }
}
