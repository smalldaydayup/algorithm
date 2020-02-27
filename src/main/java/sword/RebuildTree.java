package sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RebuildTree {

    public static void main(String[] args) {
        ArrayList<Integer> mList = new ArrayList<>();
        int[] array = {5,3,2,4,10,7,9,15};
        TreeNode node = buildTree(array);
        TreeNode copyNode = getTreeByArrays(node);

        middle_traverse(copyNode, mList);
        Integer[] arr = new Integer[mList.size()];
        mList.toArray(arr);
        for (int data : arr) {
            System.out.println("this values is " + data);
        }
    }

    public static TreeNode getTreeByArrays(TreeNode node) {
        ArrayList<Integer> fList = new ArrayList<>();
        ArrayList<Integer> mList = new ArrayList<>();

        first_traverse(node, fList);
        middle_traverse(node, mList);
        int[] fArr = getArrayByList(fList);
        int[] mArr = getArrayByList(mList);
        TreeNode root = new TreeNode(fArr[0]);
        rebuildTreeByArrays(fArr, mArr, root);
        return root;
    }

    public static int[] getArrayByList(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (int data : list) {
            arr[i] = data;
            i++;
        }
        return arr;
    }

    public static void rebuildTreeByArrays(int[] firstArray, int[] middleArray, TreeNode root) {
        int rootIndex = getIndex(middleArray, root.value);


        int[] leftFirstArray = Arrays.copyOfRange(firstArray, 1, rootIndex + 1);
        int[] leftMiddleArray = Arrays.copyOfRange(middleArray, 0, rootIndex);
        TreeNode leftNode = null;
        if (leftFirstArray.length > 0) {
            leftNode = new TreeNode(leftFirstArray[0]);
            root.left = leftNode;
        }

        if (leftFirstArray.length > 1) {
            rebuildTreeByArrays(leftFirstArray,leftMiddleArray, leftNode);
        }

        int[] rightFirstArray = Arrays.copyOfRange(firstArray, rootIndex + 1, firstArray.length);
        int[] rightMiddleArray = Arrays.copyOfRange(middleArray, rootIndex + 1, middleArray.length);
        TreeNode rightNode = null;
        if (rightFirstArray.length > 0) {
            rightNode = new TreeNode(rightFirstArray[0]);
            root.right = rightNode;
        }

        if (rightFirstArray.length > 1) {
            rebuildTreeByArrays(rightFirstArray, rightMiddleArray, rightNode);
        }
    }

    public static int getIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    public static void first_traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.value);
        first_traverse(root.left, list);
        first_traverse(root.right, list);
    }

    public static void middle_traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        middle_traverse(root.left, list);
        list.add(root.value);
        middle_traverse(root.right, list);
    }

    public static void last_traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        last_traverse(root.left, list);
        last_traverse(root.right, list);
        list.add(root.value);
    }

    public static TreeNode buildTree(int[] arrs) {
        if(arrs.length == 0) return null;

        TreeNode root = new TreeNode(arrs[0]);
        for (int i = 1; i < arrs.length; i++) {
            addTreeNode(root, arrs[i]);
        }

        return root;
    }

    public static void addTreeNode(TreeNode root, int value) {
        TreeNode cur = root;
        while((cur.value >= value && cur.left != null) || (cur.value < value && cur.right != null)) {
            if(cur.value >= value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(value);

        if(cur.value >= value) {
            cur.left = node;
        } else {
            cur.right = node;
        }
    }

}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}





