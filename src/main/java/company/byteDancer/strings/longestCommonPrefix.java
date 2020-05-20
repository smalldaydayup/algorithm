package company.byteDancer.strings;

import java.util.LinkedList;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] data = new String[]{"flower","flow","flight"};
        String res = getLongestCommonPrefix(data);
        System.out.println(res);
    }


    public  static String getLongestCommonPrefix(String[] strs) {
        if(strs.length == 0)  return "";
        if(strs.length == 1) return strs[0];

        Node root = new Node('t'); // 加一个 head 节点


        for(int i = 0; i < strs.length; i ++) {
            boolean isNew = (i == 0);
            buildTree(root, strs[i], isNew);
        }

        StringBuilder res = new StringBuilder();

        Node real = root.next;
        while (real != null) {
            res.append(real.value);
            real = real.next;
        }

        return res.toString();

    }

    public static void buildTree(Node root,  String str, boolean isNew) {
        char[] arr = str.toCharArray();
        Node cur = root;

        if (isNew) {
            for (int i = 0; i< arr.length; i ++) {
                Node node = new Node(arr[i]);
                cur.next = node;
                cur = node;
            }
        } else {
            Node preCur = cur;
            cur = preCur.next;
            for (int i = 0; i < arr.length; i++) {
                if(cur != null && arr[i] == cur.value) {
                    preCur = cur;
                    cur = preCur.next;
                } else {
                    preCur.next = null;
                }

            }
        }
    }

}

class Node {
    char value;
    Node next;

    public Node(char value) {
        this.value = value;
    }
}
