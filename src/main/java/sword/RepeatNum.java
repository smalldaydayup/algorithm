package sword;

import java.util.Arrays;

public class RepeatNum {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,4,5,3};

        int[] subArr = Arrays.copyOfRange(arr, 0, 0);
        System.out.println(subArr.length);


        System.out.println(repeatV2(arr));
    }

    public static int repeat(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = -1;
        }

        int req  = -1;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(arr1[num] == num) {
                req = num;
                break;
            }
            arr1[num] = num;
        }
        return req;
    }

    public static int repeatV2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != i) {
//                int num = arr[i];
//                if (arr[num] == num) {
//                    return num;
//                }
//            }

            int j = i;
            while (arr[j] != j) {
                int num = arr[j];
                if (arr[num] == num) {
                    return num;
                }

                int tem = arr[num];
                arr[num] = num;
                arr[j] = tem;
            }
        }
        return -1;
    }
}
