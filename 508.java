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

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ret = root.val;

        ret += getSum(root.left);
        ret += getSum(root.right);

        return ret;
    }

    private void recur(TreeNode root, Map<Integer, Integer> myMap) {
        if (root == null) {
            return;
        }

        recur(root.left, myMap);
        recur(root.right, myMap);
        
        int sum = getSum(root);

        myMap.put(sum, myMap.getOrDefault(sum, 0) + 1);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> myMap = new HashMap<>(); //sum, count

        recur(root, myMap);

        int max = 0;
        List<Integer> retList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            int count = entry.getValue();
            if (count == max) {
                retList.add(entry.getKey());
            }
            else if (count > max) {
                max = count;
                retList.clear();
                retList.add(entry.getKey());
            }
        }

        int[] ret = retList.stream().mapToInt(Integer::intValue).toArray();

        return ret;
    }
}