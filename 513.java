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
    private void findLeftVal(TreeMap<Integer, Integer> myTreeMap, TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            myTreeMap.putIfAbsent(height, root.val);
        }

        findLeftVal(myTreeMap, root.left, height+1);
        findLeftVal(myTreeMap, root.right, height+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        TreeMap<Integer, Integer> myTreeMap = new TreeMap<>();
        findLeftVal(myTreeMap, root, 0);

        return myTreeMap.lastEntry().getValue();
    }
}