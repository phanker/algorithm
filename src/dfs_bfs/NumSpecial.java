package dfs_bfs;


//1582. 二进制矩阵中的特殊位置
class NumSpecial {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] clumns = new int[mat[0].length];
        int result = 0;

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < clumns.length; j++) {
                int target = mat[i][j];
                if(target == 1){
                    rows[i]++;
                    clumns[j]++;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if(rows[i] != 1) continue;
            for (int j = 0; j < clumns.length; j++) {
                if(clumns[j] != 1) continue;

                if(mat[i][j] == 1){
                    result++;
                }
            }
        }
        return result;
    }
}