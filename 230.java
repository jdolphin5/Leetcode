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

    private void getTreeArray(TreeNode root, List<Integer> myList) {

        if (root == null) return;

        getTreeArray(root.left, myList);
        myList.add(root.val);
        getTreeArray(root.right, myList);
        
    }

    public int kthSmallest(TreeNode root, int k) {
        int result;

        List<Integer> myList = new ArrayList<>();
        getTreeArray(root, myList);
        return myList.get(k-1);

    }
}