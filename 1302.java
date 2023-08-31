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
    private void getValuesAtHeight(TreeMap<Integer, List<Integer>> myTreeMap, int height, TreeNode root) {
        if (root == null)
            return;

        List<Integer> myList = myTreeMap.getOrDefault(height, new ArrayList<>());
        myList.add(root.val);
        myTreeMap.put(height, myList);

        getValuesAtHeight(myTreeMap, height+1, root.left);
        getValuesAtHeight(myTreeMap, height+1, root.right);
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        TreeMap<Integer, List<Integer>> myTreeMap = new TreeMap<>();

        getValuesAtHeight(myTreeMap, 0, root);

        Map.Entry<Integer, List<Integer>> myEntry = myTreeMap.lastEntry();
        List<Integer> myList = myEntry.getValue();
        int ret = 0;

        for (int num : myList) {
            ret += num;
        }

        return ret;
    }
}