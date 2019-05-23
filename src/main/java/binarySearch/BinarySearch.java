package binarySearch;

import java.util.HashMap;
import java.util.Map;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length ; i ++) {
            if (map.get(arr[i]) != null)
            {
                System.out.println(arr[i]);
            }
            map.put(arr[i], i);
        }
    }
}
