package 二叉树;

/**
 * 二叉树最大深度
 */
class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.min(dfs(root.left,0),dfs(root.right,0)) + 1;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        return Math.max(dfs(root.left, deep + 1), dfs(root.right, deep + 1));
    }
}