package 二叉树;


//  Definition for a binary tree node.


/**
 * 二叉树最大深度
 */
class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        return Math.max(dfs(root.left, deep + 1), dfs(root.right, deep + 1));
    }
}
