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
    int max = 0;
    private void dfs1(TreeNode root, int len) {
        if (root == null) return;
        dfs1(root.left, 0);
        dfs1(root.right, 0);
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs2(root.left, root.val);
        }
        if (root.right != null) {
            right = dfs2(root.right, root.val);
        }
        max = Math.max(max, left + right);
    }

    private int dfs2(TreeNode root, int curVal) {
        if (root.val == curVal) {
            int left = 0;
            int right = 0;
            if (root.left != null) 
                left = dfs2(root.left, curVal);
            if (root.right != null) 
                right = dfs2(root.right, curVal);
            return 1 + Math.max(left, right);
        }
        return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs1(root, 0);
        return max;
    }
}