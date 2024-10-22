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
    private void populateMap(TreeNode root, Map<Integer, List<Integer>> levelToValMap, int height) {
        if (root == null) {
            return;
        }

        levelToValMap.putIfAbsent(height, new ArrayList<>());
        List<Integer> myList = levelToValMap.get(height);
        myList.add(root.val);

        populateMap(root.left, levelToValMap, height+1);
        populateMap(root.right, levelToValMap, height+1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, List<Integer>> levelToValMap = new HashMap<>();

        populateMap(root, levelToValMap, 0);

        List<Long> myList = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : levelToValMap.entrySet()) {
            long total = 0;

            for (int num : entry.getValue()) {
                total += num;
            }

            myList.add(total);
        }

        Collections.sort(myList, Collections.reverseOrder());

        if (myList.size() < k) {
            return -1L;
        }

        return myList.get(k-1);
    }
}