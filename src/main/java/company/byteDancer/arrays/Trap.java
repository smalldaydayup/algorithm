package company.byteDancer.arrays;

public class Trap {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] arr) {
        int len = arr.length;
        if (arr.length < 2 ){
            return 0;
        }

        int max = 0;
        int maxIndex = 0;
        int rain= 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        int leftHeight = arr[0];


        for (int i = 1; i < maxIndex; i++) {
            if(arr[i] < leftHeight) {
                rain += (leftHeight - arr[i]);
            } else if(arr[i] > leftHeight) {
                leftHeight = arr[i];
            }
        }


        int rightHeight = arr[len-1];
        for (int i = arr.length -2; i > maxIndex; i--) {
            if (arr[i] < rightHeight) {
                rain += (rightHeight - arr[i]);
            } else if( arr[i] > rightHeight) {
                rightHeight = arr[i];
            }
        }

        return rain;
    }
}
