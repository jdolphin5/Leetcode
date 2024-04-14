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
    private int sumLeft(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            }
        }

        int left = sumLeft(root.left, true);
        int right = sumLeft(root.right, false);

        return left + right;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root, false);
    }
}