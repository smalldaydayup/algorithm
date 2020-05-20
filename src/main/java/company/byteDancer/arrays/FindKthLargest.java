package company.byteDancer.arrays;

public class FindKthLargest {

    public static int findKthLargest(int[] arr, int k){
        int len = arr.length;
        return 0;

    }

    public static void buildHeap(int[] arr, int size){
        int len = arr.length;



        MinHeap heap = new MinHeap(size);


    }
}


class MinHeap {
    private Node node;
    private int size;
    private int cap;

    public MinHeap(int cap) {
        this.cap = cap;
    }

    public void insert() {
    }
}

class Node {
    public int value;

    public Node left;
    public Node right;
    public Node parent;

    public Node(int value) {
        this.value = value;
    }
}
