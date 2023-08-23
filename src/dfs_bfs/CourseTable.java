package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseTable {
    //课程表
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 1 || prerequisites.length < 1){
            return true;
        }
        //初始化入度数组
        int[] inDegree = new int[numCourses];
        //创建邻接表，保存当前节点与邻接点的关系
        List<List<Integer>> neighborInfos = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            neighborInfos.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int course = prerequisite[0]; //表示学习课程
            int preCondition = prerequisite[1]; //表示学习的先决条件
            inDegree[course] ++;
            List<Integer> neighborInfo = neighborInfos.get(preCondition);
            neighborInfo.add(course);
        }
        //申明一个队列，完成bfs的搜索规则
        Queue<Integer> queue = new LinkedList<>();
        //把没有先行条件的先加入队列
        //遍历入度数组
        for (int i = 0; i < inDegree.length; i++) {
            int degree = inDegree[i];
            if(degree == 0){
                queue.offer(i);

            }
        }
        //初始化完成课程的数量
        int count = 0;
        while (!queue.isEmpty()){
            int value = queue.poll();
            count++;
            List<Integer> list = neighborInfos.get(value);
            if(null != list){
                list.forEach(l -> {
                    if(--inDegree[l] == 0){ //如果是入度数等于0 则进入课程队列
                        queue.offer(l);
                    }
                });
            }
        }
        return count == numCourses;
    }
}