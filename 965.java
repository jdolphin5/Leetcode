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
class Solution {

    private boolean checkUnival(int val, TreeNode root) {
        if (root == null) return true;
        if (val != root.val) return false;
        return checkUnival(val, root.left) && checkUnival(val, root.right);
    }

    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;

        return checkUnival(val, root);
    }
}