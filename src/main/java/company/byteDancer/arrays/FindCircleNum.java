package company.byteDancer.arrays;

public class FindCircleNum {
    public static int size = 0;

    public static void main(String[] args) {
        int[][] arr = new int[][]{{ 1,1,0}, {1,1,1}, {0,1,1}};
        int[][] arr1 = new int[][]{{ 1,1,0}, {1,1,0}, {0,0,1}};

        System.out.println(findCircleNum(arr1));
    }

    public  static int findCircleNum(int[][] arr) {
        int len = arr.length;
        int[][] markedArr = new int[len][len];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < len; j++) {
                if (arr[i][j] != 0 && markedArr[i][j] != 1) {
                    size ++;
                    deepFind(arr, i, j, len,len, markedArr);
                }else {
                    markedArr[i][j] = 1;
                    markedArr[j][i] = 1;
                }
            }
        }

        return size;
    }


    public static void deepFind(int[][] array, int x, int y, int row, int col, int[][] mark){
        mark[x][y] = 1;
        mark[y][x] = 1;

        if (!canUp(array, x, y, row, col, mark) && !canDown(array, x, y, row, col, mark)
                && !canLeft(array, x, y, row, col, mark) && !canRight(array, x, y, row, col, mark)) {

        }

        if (canUp(array, x, y, row, col, mark)) {
            deepFind(array, x -1, y, row, col, mark);
        }

        if (canDown(array, x, y, row, col, mark)) {
            deepFind(array, x + 1, y, row, col, mark);
        }

        if (canLeft(array, x, y, row, col, mark)) {
            deepFind(array, x, y-1, row, col, mark);
        }

        if (canRight(array, x, y, row, col, mark)) {
            deepFind(array, x, y + 1, row, col, mark);
        }
    }

    public static boolean canUp(int[][] array, int x, int y, int row, int col, int[][] mark) {
        return x != 0 && array[x-1][y] == 1 && mark[x - 1][y] != 1;
    }

    public static boolean canDown(int[][] array, int x, int y, int row, int col, int[][] mark) {
        return x != row - 1 && array[x + 1][y] == 1 && mark[x + 1][y] != 1;
    }

    public static boolean canLeft(int[][] array, int x, int y, int row, int col, int[][] mark) {
        return y != 0 && array[x][y - 1] == 1 && mark[x][y - 1] != 1;
    }

    public static boolean canRight(int[][] array, int x, int y, int row, int col, int[][] mark) {
        return y != col - 1 && array[x][y + 1] == 1 && mark[x][y + 1] != 1;
    }
}
