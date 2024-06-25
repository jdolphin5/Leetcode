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
    private int total = 0;

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = dfs(root.right);
        total += root.val;
        root.val = total;
        root.left = dfs(root.left);

        return root;
    }

    public TreeNode bstToGst(TreeNode root) {
        TreeNode ret = dfs(root);
        
        return ret;
    }
}