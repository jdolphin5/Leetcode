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
    public List<Integer> preorder(Node root) {
        if (root == null) return null;
        List<Integer> result = new LinkedList();
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);
            int i = curr.children.size()-1;
            while (i >= 0) {
                stack.push(curr.children.get(i));
                i--;
            }
        }

        //result.add(root.val);
        //result.add(root.children.get(0).val);
        return result;
    }
}