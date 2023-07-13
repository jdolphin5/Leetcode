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
    private Integer prev;
    private int minDiff;
    public int getMinimumDifference(TreeNode root) 
    {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }
    private void inorderTraversal(TreeNode root) 
    {
        if (root == null) return;

        inorderTraversal(root.left);

        if (prev != null) 
            minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;

        inorderTraversal(root.right);
    }
}