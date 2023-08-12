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
    private int dfs1(TreeNode root) {

        int max = 0;
        max = Math.max(max, dfs2(root, root.val));
        if (root.left != null) {
            max = Math.max(max, dfs1(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, dfs1(root.right));
        }
        return max;
    }

    private int dfs2(TreeNode root, int ancestorVal) {
        int max = Math.abs(root.val - ancestorVal);
        if (root.left != null) {
            max = Math.max(max, dfs2(root.left, ancestorVal));
        }
        if (root.right != null) {
            max = Math.max(max, dfs2(root.right, ancestorVal));
        }
        return max;

    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        max = Math.max(dfs1(root), max);
        return max;
    }
}