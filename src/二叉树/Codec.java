package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //中序遍历值
        StringBuilder middleTraverseStr = new StringBuilder();
        //后续遍历值
        StringBuilder endTraverseStr = new StringBuilder();

        dfs(middleTraverseStr,endTraverseStr,root);

        return middleTraverseStr.append(";").append(endTraverseStr).toString();
    }

    private void dfs(StringBuilder middleTraverseStr, StringBuilder endTraverseStr, TreeNode root) {
        if(root == null){
            return;
        }
        dfs(middleTraverseStr,endTraverseStr,root.left);
        middleTraverseStr.append(root.val).append(",");
        dfs(middleTraverseStr,endTraverseStr,root.right);
        endTraverseStr.append(root.val).append(",");
    }

    /**
     * the main function of this map is storing the index's infomation of middle-squece traverse
     *  and this map's key  is value of arr.
     */
    Map<Integer,Integer> traversalMap = new HashMap<Integer,Integer>();
    String[] endArr;
    String[] middleArr;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(";");
        String middleTraverseStr = split[0];
        String endTraverseStr = split[1];

        endArr = endTraverseStr.split(",");
        middleArr = middleTraverseStr.split(",");
        for (int i = 0; i < middleArr.length; i++) {
            traversalMap.put(Integer.valueOf(middleArr[i]),i);
        }
        return restoreNode(0,middleArr.length-1,0,endArr.length-1);
    }

    private TreeNode restoreNode(int leftIn, int rightIn, int leftPost, int rightPost) {
        if(leftIn > rightIn || leftPost > rightPost){
            return null;
        }
        // System.out.println("leftPost == "+leftPost);
        // System.out.println("rightPost == "+rightPost);
        Integer rootValue = Integer.parseInt(endArr[rightPost]); //0
        TreeNode rootNode = new TreeNode(rootValue);
        Integer rootIndex = traversalMap.get(rootValue); //index of root
        // System.out.println("rootIndex == "+rootIndex);
        TreeNode left = restoreNode(leftIn,rootIndex - 1,leftPost,rootIndex + leftPost - leftIn - 1);
        TreeNode right = restoreNode(rootIndex + 1,rightIn,rootIndex + leftPost - leftIn + 1, rightPost - 1);
        rootNode.left = left;
        rootNode.right = right;
        return rootNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));