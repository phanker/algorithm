package dfs_bfs;

class NumIslands {
    public int numIslands(char[][] grid) {
        int sum = 0;//岛屿总数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char num = grid[i][j];
                if(num == '1'){
                    sum++;
                    //然后在把所有岛屿陆地标记出来
                    signIsLand(grid,i,j);
                }
            }
        }
        return sum;
    }

    private void signIsLand(char[][] grid, int i, int j) { //疑问是以前遍历到地地方 又全部遍历了一次
        //不用往上看，只往下和右边看，因为上面已经全看了
        if(i < 0 || j < 0
            || j >= grid[i].length || i >= grid.length || grid[i][j] == '0' || grid[i][j] == '2'){
            return;
        }
        grid[i][j] = '2';
        signIsLand(grid,++i,j);
        signIsLand(grid,i,++j);
        signIsLand(grid,--i,j);
        signIsLand(grid,i,--j);
    }

}