package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

//934. 最短的桥
class ShortestBridge {

    public static void main(String[] args) {
        int[][] newInt = new int[3][3];
        newInt[0] = new int[]{0,1,0};
        newInt[1] = new int[]{0,0,0};
        newInt[2] = new int[]{0,0,1};
        System.out.println(new ShortestBridge().shortestBridge(newInt));
    }

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        //先找到第一座桥
        A:for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    //递归桥，找到桥的边界
                    dfs(x, y, grid,queue);
                    break A;
                }
            }
        }
        while(!queue.isEmpty()){
            result ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] side = queue.poll(); //桥的边缘
                int x = side[0];
                int y = side[1];
                if(isLegal(x-1,y,grid) && grid[x-1][y] == 1){
                    return result;
                }else if(isLegal(x-1,y,grid) && grid[x-1][y] == 0){
                    grid[x-1][y] = 2;
                    queue.offer(new int[]{x-1,y});
                    //每个节点向四方扩散判断下个节点是否是岛屿
                }
                if(isLegal(x+1,y,grid) && grid[x+1][y] == 1){
                    return result;
                }else if(isLegal(x+1,y,grid) && grid[x+1][y] == 0){
                    grid[x+1][y] = 2;
                    queue.offer(new int[]{x+1,y});
                    //每个节点向四方扩散判断下个节点是否是岛屿
                }

                if(isLegal(x,y-1,grid) && grid[x][y-1] == 1){
                    return result;
                }else if(isLegal(x,y-1,grid) && grid[x][y-1] == 0){
                    grid[x][y-1] = 2;
                    queue.offer(new int[]{x,y-1});
                    //每个节点向四方扩散判断下个节点是否是岛屿
                }

                if(isLegal(x,y+1,grid) && grid[x][y+1] == 1){
                    return result;
                }else if(isLegal(x,y+1,grid) && grid[x][y+1] == 0){
                    grid[x][y+1] = 2;
                    queue.offer(new int[]{x,y+1});
                    //每个节点向四方扩散判断下个节点是否是岛屿
                }
            }
        }

        return result;
    }

    private boolean isLegal(int x, int y, int[][] grid) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 2)  return true;
        return false;
    }

    private void dfs(int x, int y, int[][] grid,Queue<int[]>  queue) {
        if(!isLegal(x,y,grid)){
            return;
        }
        if(grid[x][y] == 0){
            queue.offer(new int[]{x, y});
            return;
        }
        grid[x][y] = 2;
        //向四方扩散
        dfs(x-1,y,grid,queue);
        dfs(x+1,y,grid,queue);
        dfs(x,y-1,grid,queue);
        dfs(x,y+1,grid,queue);
    }
}