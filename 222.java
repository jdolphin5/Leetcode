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

    private int traverse(TreeNode root, int ret) {
        //System.out.println(root.val);
        ret++;

        if (root.left == null && root.right == null) {
            return ret;
        } 
        if (root.left != null) {
            ret = traverse(root.left, ret);
        }
        if (root.right != null) {
            ret = traverse(root.right, ret);
        }

        return ret;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int ret = 0;

        return traverse(root, ret);
        
    }
}