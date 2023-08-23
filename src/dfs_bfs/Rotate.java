package dfs_bfs;

//矩阵顺时针旋转90度
class Rotate {


    /**
        查看到矩阵的旋转，元素变换的规律
        x,y ->  y,n-x-1
        0，0  0，2
        0，1  1，2
        0，2  2，2

        1，0  0，1
        1，1  1，1
        1，2  2，1

        2，0  0，0
        2，1  1，0
        2，2  2，0

     */ 
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int x = 0; x < n/2; x++) {
            for (int y = 0; y < (n+1)/2; y++) {
                int maxIndex = n-1;
                int target = matrix[x][y]; //1
                matrix[x][y]  = matrix[maxIndex-y][x];
                matrix[maxIndex-y][x] = matrix[maxIndex-x][maxIndex-y];
                matrix[maxIndex-x][maxIndex-y] = matrix[y][maxIndex-x];
                matrix[y][maxIndex-x] = target;
            }
        }
    }

}