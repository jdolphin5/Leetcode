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
    private void traverseAndCount(Map<Integer, Integer> myMap, TreeNode root) {
        if (root == null) {
            return;
        }

        myMap.put(root.val, myMap.getOrDefault(root.val, 0) + 1);

        traverseAndCount(myMap, root.left);
        traverseAndCount(myMap, root.right);
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> myMap = new HashMap<>();

        traverseAndCount(myMap, root);

        List<Integer> retList = new ArrayList<>();
        int maxModeCount = 0;

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if (value > maxModeCount) {
                retList.clear();
                retList.add(key);
                maxModeCount = value;
            }
            else if (value == maxModeCount) {
                retList.add(key);
            }
        }

        int[] ret = new int[retList.size()];

        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }

        return ret;
    }
}