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

    private static int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 1;

        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = dfs(root.left);
        }
        if (left == -1) return -1;

        if (root.right != null) {
            right = dfs(root.right);
        }
        if (right == -1) return -1;

        if (Math.abs(left-right) > 1) return -1;
        return Math.max(left, right)+1;
        
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int result = dfs(root);
        if (result != -1) return true;
        return false;
    }
}