package dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {


    Map<Integer, Node> exsitNodes = new HashMap();//存储存在过的节点

    public static void main(String[] args) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = new ArrayList<Node>(){
            {
                add(node2);
                add(node4);
            }
        };
        node2.neighbors = new ArrayList<Node>(){
            {
                add(node1);
                add(node3);
            }
        };

        node3.neighbors = new ArrayList<Node>(){
            {
                add(node2);
                add(node4);
            }
        };
        node4.neighbors = new ArrayList<Node>(){
            {
                add(node1);
                add(node3);
            }
        };
        Node node = new Solution().cloneGraph(node1);
        System.out.println(node);
    }

    public Node cloneGraph(Node node) {

        if (node == null) return node;

        if (exsitNodes.containsKey(node.val)) {
            return exsitNodes.get(node.val);
        }
        Node newNode = new Node(node.val);
        exsitNodes.put(node.val, newNode);
        List<Node> neighbors = node.neighbors;
        if (null != neighbors && neighbors.size() > 0) {
            newNode.neighbors = new ArrayList<>();
            for (int i = 0; i < neighbors.size(); i++) {
                newNode.neighbors.add(cloneGraph(neighbors.get(i)));
            }
        }
        return newNode;
    }
}