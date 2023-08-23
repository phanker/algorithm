package dfs_bfs;

import java.util.*;

class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //设定临时数组存放k节点到每个节点的路径值在，假设每个到每个节点都是一个最大值
        int[] temp = new int[n];
        Arrays.fill(temp,Integer.MAX_VALUE);
        //设定一个Map存放每个节点的邻接信息
        HashMap<Integer, List<int[]>> neighborMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] edge = times[i];
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            neighborMap.computeIfAbsent(u-1,o->new ArrayList<>()).add(new int[]{v-1,w});
        }
        //创建优先队列 用来存储k节点到每个节点的最短距离
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        temp[k-1] = 0;
        queue.offer(new int[]{k-1,0}); //从k节点开始

        boolean[] visited = new boolean[n];
        int result = 0; //结果
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int node = poll[0];
            int score = poll[1];
            visited[node] = true;
            //这里必须有这个判断
            // [1，2，1] [1,3,4] [2,3,2] 这种情况下要判断,为了减少下面的判断逻辑。如果在这里要拿到最长的访问距离，这个判断必不可少
            if(score > temp[node]){
                continue;
            }
            result = Math.max(score, result);
            List<int[]> neighbors = neighborMap.get(node);
            if(neighbors == null){
                continue;
            }
            neighbors.forEach(neighbor ->{
                int oldDestince = temp[neighbor[0]];
                int destince = score + neighbor[1];
                if(destince < oldDestince){
                    temp[neighbor[0]] = destince;
                    int[] newInt = {neighbor[0],destince};
                    queue.offer(newInt);

                }
            });
        }



//        for (int i = 0; i < visited.length; i++) {
//            if(!visited[i]) return  -1;
//        }

        int maxDelay = 0;
        for (int i = 0; i < n; i++) {
            if (temp[i] == Integer.MAX_VALUE) {
                return -1; // 无法到达该节点
            }
            maxDelay = Math.max(maxDelay, temp[i]);
        }

        return maxDelay;
    }

    public static void main(String[] args) {
        int[][] i = {{1,2,1},{2,3,2},{1,3,4}};
        int i1 = new NetworkDelayTime().networkDelayTime(i, 3, 1);
        System.out.println(i1);

    }
}