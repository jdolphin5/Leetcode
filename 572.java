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

    private boolean areTreeEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        boolean left = true;
        boolean right = true;
        if (root.left != null || subRoot.left != null) {
            left = areTreeEqual(root.left, subRoot.left);
        }
        if (root.right != null || subRoot.right != null) {
            right = areTreeEqual(root.right, subRoot.right);
        }
        return left && right;

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (areTreeEqual(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
}