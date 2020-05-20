package company.byteDancer.arrays;

public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,2};
        System.out.println(findLengthOfLCIS(arr));
    }

    public static int findLengthOfLCIS(int[] arr){
        if (arr.length == 0) {
            return 0;
        }

        int cur = arr[0];
        int max = 1;
        int curLen = 1;
        for(int i = 1; i < arr.length; i ++) {
            if (arr[i] > cur) {
                curLen ++;
                max = Math.max(max, curLen);

            } else {
                curLen = 1;

            }
            cur = arr[i];
        }

        return max;
    }
}
