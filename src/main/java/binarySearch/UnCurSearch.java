package binarySearch;

import utils.Node;

import java.util.HashMap;
import java.util.Stack;

public class UnCurSearch {
    public static void preSearch(Node head){
        if (head == null) return;
        Node p = head;
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || p !=null){
            while (p != null) {
                visitNode(p);
                stack.push(p);
                p = p.leftNode;
            }

            if (!stack.empty()) {
                p = stack.pop();
                p = p.rightNode;
            }
        }


    }


    public static void midSearch(Node head){
        if (head == null) return;
        Node p = head;
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || p !=null){
            while (p != null) {
                stack.push(p);
                p = p.leftNode;
            }

            if (!stack.empty()) {
                p = stack.pop();
                visitNode(p);
                p = p.rightNode;
            }
        }
    }

    public static void visitNode(Node node){
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Node headNode = null;
        int[] arr = {7,4,1,5,11,8,12};
        for(int i : arr){
            if (headNode == null){
                headNode = new Node(i);
            }else {
                Node.constructNode(headNode, i);
            }
        }

        UnCurSearch.midSearch(headNode);

        HashMap<String, String> st = new HashMap<>();
        st.put("lsy", "zk");
        st.put("lsy", "kgg");
        System.out.println(st.get("lsy"));



    }

}
