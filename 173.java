/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    List<Integer> myList = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {
        traversal(root);
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        myList.add(root.val);
        traversal(root.right);
    }
    
    public int next() {
        return myList.get(index++);
    }
    
    public boolean hasNext() {
        if (index < myList.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */