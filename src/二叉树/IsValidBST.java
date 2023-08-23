package 二叉树;

/**
 * 98. 验证二叉搜索树
 */
class IsValidBST {
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//    }
//
//    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
//        if(root == null)  return true;
//        int val = root.val;
//        if(val <= minValue || val >= maxValue){
//            return false;
//        }
//        return isValidBST(root.left,minValue,val) && isValidBST(root.right,val,maxValue);
//    }

    int minNum = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,minNum);
    }

    private boolean isValidBST(TreeNode root, int minValue) {
        if(root == null)  return true;
        if(!isValidBST(root.left,minNum)) return false;
        int val = root.val;
        if(val <= minNum) return false;
        minNum = val;
        return isValidBST(root.right,minValue);
    }


}