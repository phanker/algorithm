package 二叉树;

class LowestCommonAncestor {
    TreeNode target = null;
    boolean isInTree(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //后续遍历
        boolean inLeft = isInTree(root.left,p,q);
        boolean inRight = isInTree(root.right,p,q);
        if(inLeft && inRight){ //表示当前节点就是其相交节点
            target = root;
        }
        if((inLeft || inRight) && (root == p || root == q)){
            //表示之前有一个节点被找到，现在另一个也被找到，并且为当前的节点
            //所以当前这个节点为远祖节点
            target = root;
        }
        // 如果找到一方的包含关系，返回true。或者当前节点有包含关系也返回true
        return inLeft || inRight || root == p || root == q;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isInTree(root,p,q);
        return target;
    }
}