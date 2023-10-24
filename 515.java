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
    private void findMaxValues(Map<Integer, Integer> myMap, TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (root.val >= myMap.getOrDefault(height, Integer.MIN_VALUE)) {
            myMap.put(height, root.val);
        }

        findMaxValues(myMap, root.left, height+1);
        findMaxValues(myMap, root.right, height+1);
    }

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> myMap = new HashMap<>();

        findMaxValues(myMap, root, 0);

        List<Integer> ret = new ArrayList<>();
        int i = 0;
       
        while (myMap.get(i) != null) {
            ret.add(myMap.get(i));
            i++;
        }

        return ret;
    }
}