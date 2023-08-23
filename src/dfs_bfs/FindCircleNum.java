package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

//547. 省份数量
class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        boolean[] isVisited = new boolean[n]; //存储统计过的城市
        List<List<Integer>> adjoinList = new ArrayList<>(); //邻接表
        for (int i = 0; i < n; i++) {
            adjoinList.add(new ArrayList<>());
        }
        for (int x = 0; x < isConnected.length; x++) {
            for (int y = 0; y < isConnected[0].length; y++) {
                if(isConnected[x][y] == 1){
                    adjoinList.get(x).add(y);
                }
            }
        }
        for (int i = 0; i < adjoinList.size(); i++) {
            if(!isVisited[i]){
                result++;
                dfs(isVisited,adjoinList,i);
            }
        }
        return result;
    }

    private void dfs(boolean[] isVisited, List<List<Integer>> adjoinList, int i) {
        if(isVisited[i]) return;
        isVisited[i] = true;
        List<Integer> adjoinElements = adjoinList.get(i);
        adjoinElements.forEach(element->{
            dfs(isVisited,adjoinList,element);
        });
    }
}