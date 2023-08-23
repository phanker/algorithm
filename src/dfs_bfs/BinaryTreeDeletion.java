package dfs_bfs;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDeletion {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 找到目标节点
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 情况1：目标节点为叶子节点
            if (root.left == null && root.right == null) {
                root = null;
            }
            // 情况2：目标节点只有一个子节点
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // 情况3：目标节点有两个子节点
            else {
                TreeNode successor = findSuccessor(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }

        return root;
    }

    private TreeNode findSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        // 创建二叉树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        BinaryTreeDeletion deletion = new BinaryTreeDeletion();

        // 删除叶子节点
        TreeNode result1 = deletion.deleteNode(root, 1);
        System.out.println("删除叶子节点后的树结构：");
        printTree(result1);
        System.out.println();

        // 删除只有一个子节点的节点
        TreeNode result2 = deletion.deleteNode(root, 6);
        System.out.println("删除只有一个子节点的节点后的树结构：");
        printTree(result2);
        System.out.println();

        // 删除有两个子节点的节点
        TreeNode result3 = deletion.deleteNode(root, 2);
        System.out.println("删除有两个子节点的节点后的树结构：");
        printTree(result3);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}


