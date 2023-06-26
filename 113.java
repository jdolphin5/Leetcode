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
    private List<List<Integer>> checkPath(List<List<Integer>> ret, List<Integer> curPath, TreeNode root, int targetSum, int curSum) {
        if (root == null) return ret;
        curPath.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == targetSum) {
                List<Integer> toAdd = new ArrayList<>();
                for (Integer num : curPath) {
                    toAdd.add(num);
                }
                ret.add(toAdd);
            }
        }
        if (root.left != null)
            checkPath(ret, curPath, root.left, targetSum, curSum);
        if (root.right != null)
            checkPath(ret, curPath, root.right, targetSum, curSum);
        curPath.remove(curPath.size()-1);
        curSum -= root.val;
        return ret;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        return checkPath(ret, curPath, root, targetSum, 0);
    }
}