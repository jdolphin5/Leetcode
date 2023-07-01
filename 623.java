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
    private void recur(TreeNode root, int val, int depth, int curDepth) {
        if (depth == curDepth) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode leftNode = new TreeNode();
            leftNode.val = val;
            leftNode.left = root.left;
            root.left = leftNode;
            TreeNode rightNode = new TreeNode();
            rightNode.val = val;
            rightNode.right = root.right;
            root.right = rightNode;
        }
        if (root.left != null) {
            recur(root.left, val, depth, curDepth+1);
        }
        if (root.right != null) {
            recur(root.right, val, depth, curDepth+1);
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;
        if (depth == 1) {
            TreeNode node = new TreeNode();
            node.val = val;
            node.left = root;
            return node;
        }
        recur(root, val, depth, 2);
        return root;
    }
}