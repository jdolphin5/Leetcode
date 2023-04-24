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
    int count = 0;
    Map<Long, Integer> myMap = new HashMap<Long, Integer>();
    public int pathSum(TreeNode root, long targetSum) {
        myMap.put((long)0, 1);
        dfs(root, 0, targetSum);
        return count;
    }

    private void dfs (TreeNode root, long curSum, long tar) {
        if (root == null) return;

        curSum += root.val;

        if (myMap.containsKey(curSum - tar)) {
            count += myMap.get(curSum - tar);
        }
        
        myMap.put(curSum, myMap.getOrDefault(curSum, 0) + 1);

        dfs(root.left, curSum, tar);
        dfs(root.right, curSum, tar);

        if (myMap.get(curSum) == 1) {
            myMap.remove(curSum);
        }
        else {
            myMap.put(curSum, myMap.get(curSum) - 1);
        }

    }
}