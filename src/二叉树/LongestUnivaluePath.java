package 二叉树;


//687. 最长同值路径 ,这题没弄懂
class LongestUnivaluePath {
    int result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

//        System.out.println(root.val);
        if(root.left != null && root.left.val == root.val){
            left = left + 1;
        }else{
            left = 0;
        }

        if(root.right != null && root.right.val == root.val){
            right = right + 1;
        }else{
            right = 0;
        }
        result = Math.max(left+right,result);
        System.out.println("result:"+result);
        System.out.println("left+right:"+(left+right));
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        // 创建二叉树
        /**
         *          5
         *      5       5
         *    5   5       5
         *
         */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        // 计算最长同值路径长度
        int longestPathLength = new LongestUnivaluePath().longestUnivaluePath(root);
        System.out.println("最长同值路径的长度：" + longestPathLength);
    }
}