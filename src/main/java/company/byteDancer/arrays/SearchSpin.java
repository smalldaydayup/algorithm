package company.byteDancer.arrays;

public class SearchSpin {
    public static int max = -1;

    public static void main(String[] args) {
        int[] arr =  {4,5,6,7,8,9,10,11,0,1,2,3};
        searchSpin(arr, 0, arr.length - 1);
        System.out.println(max);
    }

    protected static void searchSpin(int[] arr, int head, int tail) {
        if (tail - head < 2 && arr[head] > arr[tail]){
            max = head;
        }

        int middle = (tail + head) / 2;



        if (arr[middle] > arr[head] && arr[middle] > arr[tail]) {
            searchSpin(arr, middle, tail);
        } else if (arr[middle] > arr[head] && arr[middle] < arr[tail]) {
            // 不作处理
        } else if (arr[middle] < arr[head] && arr[middle] < arr[tail]) {
            searchSpin(arr, head, middle);
        } else {

        }

    }
}
