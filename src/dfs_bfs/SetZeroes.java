package dfs_bfs;

//73. 矩阵置零
class SetZeroes {
    public void setZeroes(int[][] matrix) {
//        boolean[] rows = new boolean[matrix.length]; //存储矩阵的行是否含有0
//        boolean[] columns = new boolean[matrix[0].length];//存储矩阵的列是否含有0
//
//        for (int x = 0; x < rows.length; x++) {
//            for (int y = 0; y < columns.length; y++) {
//                if(matrix[x][y] == 0){
//                    rows[x] = Boolean.TRUE;
//                    columns[y] = Boolean.TRUE;
//                }
//            }
//        }
//
//        for (int x = 0; x < rows.length; x++) {
//            for (int y = 0; y < columns.length; y++) {
//                if(rows[x] == true || rows[y] == true){
//                    matrix[x][y] = 0;
//                }
//            }
//        }
        boolean row = false;
        boolean col = false;

        for (int x = 0; x < matrix.length; x++) {
            if(matrix[x][0] == 0) row = true;
        }

        for (int y = 0; y < matrix[0].length; y++) {
            if(matrix[0][y] == 0) col = true;
        }

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if(matrix[x][y] == 0){
                    matrix[x][0] = 0;
                    matrix[0][y] = 0;
                }
            }
        }

        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[0].length; y++) {
                if (matrix[x][0] == 0 || matrix[0][y] == 0) {
                    matrix[x][y] = 0;
                }
            }
        }


        if(col){
            for (int y = 0; y < matrix[0].length; y++) matrix[0][y] = 0;
        }

        if(row){
            for (int x = 0; x < matrix.length; x++) matrix[x][0] = 0;
        }
    }
}