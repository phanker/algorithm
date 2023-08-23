package dfs_bfs;

import java.util.Arrays;



//把数的平方按照瞬时针旋转在，填充每个坐标
class GenerateMatrix {

    //查找上下左右的规律

    /**
     *
     *
     *  - 向右
     *  0 ,y++
     *
     *  | 向下
     *  x++,y
     *
     *  向左
     *  x,y--
     *
     *  | 向上
        x-- y
     *
     * 注意边界

     */
    public int[][] generateMatrix(int n) {
        int maxNum = n*n; //最大数
        int currentNum = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int blow = n - 1;

        int[][] newInt = new int[n][n];
        while (currentNum < maxNum){

            for (int i = 0; i + left <= right; i++) {
                newInt[left][left + i] = ++currentNum;
            }
            top++;

            for (int i = 0; i + top <= blow; i++) {
                newInt[top+i][right] = ++currentNum;
            }
            right--;

            for (int i = 0; i <= right - left; i++) {
                newInt[blow][right-i] = ++currentNum;
            }
            blow--;

            for (int i = 0; i <= blow - top; i++) {
                newInt[blow-i][left] = ++currentNum;
            }
            left++;

        }
        return newInt;
    }

    public static void main(String[] args) {

        int[][] ints = new GenerateMatrix().generateMatrix(4);
        for (int i = 0; i <ints .length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}