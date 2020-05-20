package company.byteDancer.arrays;

public class MaxAreaOfIsland {
    public static int max = 0;
    public static int cur = 0;

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };

        System.out.println(maxAreaOfIsland(arr));
    }

    public static int maxAreaOfIsland(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int[][] markedArr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (array[i][j] != 0 && markedArr[i][j] != 1) {
                    cur = 1;
                    deepRecursive(array, i, j, row, col, markedArr);
                } else {
                    markedArr[i][j] = 1;
                }
            }
        }

        return max;
    }

    public static void deepRecursive(int[][] array, int x, int y, int row, int col, int[][] mark) {
        mark[x][y] = 1;

        if (!canUp(array, x, y, row, col, mark) && !canDown(array, x, y, row, col, mark)
                && !canLeft(array, x, y, row, col, mark) && !canRight(array, x, y, row, col, mark)) {
            if (cur > max) {
                max = cur;
            }
        }

        if (canUp(array, x, y, row, col, mark)) {
            cur ++;
            deepRecursive(array, x - 1, y, row, col, mark);
        }

        if (canDown(array, x, y, row, col, mark)) {
            cur ++;
            deepRecursive(array, x + 1, y, row, col, mark);
        }

        if (canLeft(array, x, y, row, col, mark)) {
            cur ++;
            deepRecursive(array, x, y-1, row, col, mark);
        }

        if (canRight(array, x, y, row, col, mark)) {
            cur ++;
            deepRecursive(array, x, y + 1, row, col, mark);
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
