package company.byteDancer.arrays;

import java.util.HashMap;
import java.util.LinkedList;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums, 0);
    }

    public static void threeSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }


        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length -1; j++) {
                for (int k = i + 2; k < arr.length; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == sum) {
                        int[] tmp = new int[]{arr[i], arr[j], arr[k]};
                        list.add(tmp);
                    }
                }
            }
        }

        System.out.println(list.toString());
    }
}
