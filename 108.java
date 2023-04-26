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

    private TreeNode dfs(int[] nums, int lower, int upper) {
        TreeNode root = new TreeNode();
        
        int mid = lower + (upper - lower) / 2 ;

        root.val = nums[mid];

        if (mid > lower) {
            root.left = dfs(nums, lower, mid-1);
        }
        if (mid < upper) {
            root.right = dfs(nums, mid+1, upper);
        }

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = dfs(nums, 0, nums.length-1);

        return root;
    }
}