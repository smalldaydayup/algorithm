package company.byteDancer.arrays;

public class GetPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {
        int remain = k;
        String[] arr = getInit(n);
        for (int i = 0; i < n -1; i++) {
            if (remain == 1) {
                break;
            }
            int remianNum = n - 1- i;
            int multi = multiStep(remianNum);
            int idx = (remain -1) / multi;
            if (idx > 0) {
                String tmp = arr[i];
                arr[i] = arr[i + idx];
                arr[i + idx] = tmp;
                remain = remain - (idx * multi);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s: arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static String[] getInit(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i + 1);
        }

        return arr;
    }

    public static int multiStep(int n) {
        if (n == 1) {
            return 1;
        }

        return multiStep(n-1) * n;
    }
}
