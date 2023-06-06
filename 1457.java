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

    private boolean checkPal(int[] nums) {
        boolean odd = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }

    private int traverse(TreeNode root, int[] nums, int ret) {
        if (root.left == null && root.right == null) {
            nums[root.val]++;
            if (checkPal(nums)) ret++;
            nums[root.val]--;
            return ret;
        }

        nums[root.val]++;

        if (root.left != null) {
            ret = traverse(root.left, nums, ret);
        }
        if (root.right != null) {
            ret = traverse(root.right, nums, ret);
        }

        nums[root.val]--;
        return ret;

    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] nums = new int[10];
        return traverse(root, nums, 0);

    }
}