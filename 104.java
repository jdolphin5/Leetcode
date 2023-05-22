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
    private int maxHeight(TreeNode root, int height) {
        int left = height;
        int right = height;
        
        if (root.left != null) {
            left = maxHeight(root.left, height+1);
        }
        
        if (root.right != null) {
            right = maxHeight(root.right,height+1);
        }
        

        return Math.max(left, right);
        
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxHeight(root, 1);
    }
}