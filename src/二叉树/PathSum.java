package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer 34. 二叉树中和为某一值的路径
class PathSum {



    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>>  result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        pathSum(root,target,deque,result);
        return result;
    }

    private void pathSum(TreeNode root, int target, Deque<Integer> deque,List<List<Integer>> result) {
        if(root == null){
            return;
        }
        deque.addLast(root.val);
        if(root.left == null && root.right == null && root.val == target){
            result.add(new LinkedList<>(deque));
            return;
        }
        pathSum(root.left,target - root.val,deque,result);
        pathSum(root.right,target - root.val,deque,result);
        deque.pollLast();
    }

}