package utils;

import java.util.Scanner;

public class Node {
    public int value;
    public Node rightNode = null;
    public Node leftNode = null;

    public Node(int value) {
        this.value = value;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public static void constructNode(Node head, int value){
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        if (head.value < value) {
            if (head.rightNode == null) {
                head.rightNode = node;
                return;
            }
            constructNode(head.rightNode, value);
        } else {
            if (head.leftNode == null) {
                head.leftNode = node;
                return;
            }
            constructNode(head.leftNode, value);
        }
    }

    public static void firstP(Node node){
        if(node == null){ return; }
        System.out.println(node.value);
        firstP(node.leftNode);
        firstP(node.rightNode);
    }

    public static void middleP(Node node){
        if(node == null){ return; }
        middleP(node.leftNode);
        System.out.println(node.value);
        middleP(node.rightNode);
    }

    public static void  main(String[] args){
        Node headNode = null;
        Scanner sc = new Scanner(System.in);
        String s = "";
        if (sc.hasNextLine()) {
            s = sc.nextLine();
        }
        String[] arr = s.split(" ");
        int[] arr_int = new int[arr.length];
        for(int i=0; i< arr.length; i++){
            arr_int[i] = Integer.parseInt(arr[i]);
        }

        System.out.println(arr_int.length);

        for(int i : arr_int){
            if (headNode == null){
                headNode = new Node(i);
            }else {
                Node.constructNode(headNode, i);
            }
        }

        System.out.println(headNode);

        Node.firstP(headNode);
        Node.middleP(headNode);

    }
}

