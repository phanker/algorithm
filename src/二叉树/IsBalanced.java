package 二叉树;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 */
class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDeep = dfs(root.left);
        if(leftDeep == -1){
            return -1;
        }
        int rightDeep = dfs(root.right);
        if(rightDeep == -1){
            return -1;
        }
        if(Math.abs(leftDeep-rightDeep) > 1){
            return -1;
        }
        return Math.max(leftDeep,rightDeep)+1;
    }
}