package 二叉树;

import java.util.*;

//剑指 Offer 32 - III. 从上到下打印二叉树 III
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return null;
        List<List<Integer>> lists = new ArrayList();
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean flag = false;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> treeNodes = new LinkedList<>();
            lists.add(treeNodes);
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.pollFirst();
                if(!flag){
                    treeNodes.add(treeNode.val);
                }else{
                    treeNodes.addFirst(treeNode.val);
                }
                if(null != treeNode.left) queue.offerLast(treeNode.left);
                if(null != treeNode.right) queue.offerLast(treeNode.right);
            }
            flag = !flag;
        }
        return lists;
    }
}