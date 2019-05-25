package binarySearch;

import utils.Node;

import java.util.Arrays;

public class RebuilderTree {
    Node node = new Node(5);

    public static void buildTree(Node head, int[] arr1, int[] arr2) {
        int currentRoot = arr1[0];
        int len = arr1.length;
        int indexAt = find_at(currentRoot, arr2);

        // 处理左子树
        if (indexAt == 0) {

        }else {

            if (indexAt == 1) {
                Node node = new Node(arr2[0]);
                head.leftNode = node;
            } else {
                int[] sub_arr1_s = Arrays.copyOfRange(arr1,1, indexAt + 1);
                int[] sub_arr2_s = Arrays.copyOfRange(arr2, 0, indexAt);
                Node node1 = new Node(arr1[1]);
                head.leftNode = node1;
                buildTree(head.leftNode, sub_arr1_s,sub_arr2_s);
            }
        }

        // 处理右子树
        if (indexAt == arr1.length - 1) {

        } else {
            if (indexAt == arr1.length - 2) {
                Node node = new Node(arr2[len - 1]);
                head.rightNode = node;
            } else {
                int[] sub_arr1_e = Arrays.copyOfRange(arr1, indexAt + 1, len);
                int[] sub_arr2_e = Arrays.copyOfRange(arr2, indexAt + 1, len);
                Node node2 = new Node(arr1[indexAt + 1]);
                head.rightNode = node2;
                buildTree(head.rightNode, sub_arr1_e, sub_arr2_e);
            }
        }

    }

    public static int find_at(int value, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (value ==arr[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {3,2,5,4,1,6};
        Node head = new Node(arr1[0]);
        buildTree(head, arr1, arr2);

        Node.firstP(head);
        Node.middleP(head);
    }

}
