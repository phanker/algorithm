package 二叉树;

//112. 路径总和
class HasPathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }

        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }


}
