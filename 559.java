/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    private int maxHeight(Node root, int max) {
        List<Node> children = root.children;
        int ret = max;
        for (Node node : children) {
            ret = Math.max(ret, maxHeight(node, max+1));
        }

        return ret;
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
    
        return maxHeight(root, 1);
        
    }
}