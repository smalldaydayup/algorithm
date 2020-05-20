package company.byteDancer.arrays;

import java.util.Arrays;

public class IntervalMerge {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3}, {8,10}, {15,18}, {2,6}, {16, 30}};

        int[][] newArr = intervalMerge(arr);
        System.out.println(newArr);

    }

    public static int[][] intervalMerge(int[][] arr) {
        int len = arr.length;
        int[][] res = new int[len][2];
        int cur = 0;

        sortArr(arr);
        res[0] = arr[0];

        for(int i = 1; i< arr.length; i++){
            if (res[cur][1] > arr[i][0]) {
                if(res[cur][1] < arr[i][1]) {
                    res[cur][1] = arr[i][1];
                }
            } else {
                cur ++;
                res[cur] = arr[i];
            }
        }

        return Arrays.copyOfRange(res, 0, cur + 1);

    }

    public static void sortArr(int[][] arr) {
        int len = arr.length;
        insertSort(arr);
    }

    public static void insertSort(int[][] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[i][0] > arr[j][0]) {
                    int[] tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
