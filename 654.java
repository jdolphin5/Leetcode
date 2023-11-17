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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int[] leftArr = new int[maxIndex];
        int[] rightArr = new int[nums.length-maxIndex-1];

        for (int i = 0; i < maxIndex; i++) {
            leftArr[i] = nums[i];
        }

        for (int i = 0; i < nums.length-maxIndex-1; i++) {
            rightArr[i] = nums[i+maxIndex+1];
        }

        TreeNode root = new TreeNode(max, constructMaximumBinaryTree(leftArr), constructMaximumBinaryTree(rightArr));

        return root;
    }
}