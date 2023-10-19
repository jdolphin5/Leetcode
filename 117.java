/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private void traverse(Map<Integer, List<Node>> myMap, int height, Node root) {
        if (root == null) {
            return;
        }

        List<Node> curList = myMap.getOrDefault(height, new ArrayList<>());

        curList.add(root);

        myMap.put(height, curList);

        traverse(myMap, height+1, root.left);
        traverse(myMap, height+1, root.right);
    }

    private void populateNext(Map<Integer, List<Node>> myMap, int height, Node root) {
        if (root == null) {
            return;
        }

        List<Node> curList = myMap.getOrDefault(height, new ArrayList<>());
        if (curList.size() > 1) {
            root.next = curList.get(1);
            curList.remove(0);
            myMap.put(height, curList);
        }

        populateNext(myMap, height+1, root.left);
        populateNext(myMap, height+1, root.right);
    }

    public Node connect(Node root) {
        Map<Integer, List<Node>> myMap = new HashMap<>();

        traverse(myMap, 0, root);

        populateNext(myMap, 0, root);

        return root;
    }
}