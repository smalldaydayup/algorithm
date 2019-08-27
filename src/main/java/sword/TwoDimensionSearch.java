package sword;

public class TwoDimensionSearch {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean ret = contain(14, arr);
        System.out.println(ret);
    }

    public static boolean contain(int obj, int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        boolean flag = false;
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (arr[i][j] == obj) {
                return true;
            } else if (arr[i][j] > obj) {
                j--;
                continue;
            } else {
                i++;
                continue;
            }
        }
        return flag;
    }
}
