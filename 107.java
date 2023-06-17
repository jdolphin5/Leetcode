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

    private int addNode(Map<Integer, List<Integer>> myMap, int height, TreeNode root) {
        if (root == null) {
            return height;
        }
        List<Integer> myList = myMap.getOrDefault(height, new ArrayList<>());
        myList.add(root.val);
        myMap.put(height, myList);

        int nextHeight = height+1;

        height = addNode(myMap, nextHeight, root.left);
        height = Math.max(height, addNode(myMap, nextHeight, root.right));

        return height;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int height = addNode(myMap, 0, root);
        for (int i = height-1; i >= 0; i--) {
            res.add(myMap.get(i));
        }
        return res;
    }
}