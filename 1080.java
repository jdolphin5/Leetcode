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
    
    private TreeNode checkDelNodes(TreeNode root, int limit, int sum) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (sum+root.val < limit) {
                return null;
            }
            return root;
        }
        TreeNode left = checkDelNodes(root.left, limit, sum+root.val);
        TreeNode right = checkDelNodes(root.right, limit, sum+root.val);
        if (left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;

        return root;
    }


    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        return checkDelNodes(root, limit, 0);
    }
}