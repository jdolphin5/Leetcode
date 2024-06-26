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
    private void populateList(TreeNode root, List<Integer> myList) {
        if (root == null) {
            return;
        }

        myList.add(root.val);
        populateList(root.left, myList);
        populateList(root.right, myList);
    }

    private TreeNode constructTree(int lower, int upper, List<Integer> myList) {
        if (lower >= upper) {
            return null;
        }

        int mid = lower + (upper - lower) / 2;

        TreeNode node = new TreeNode(myList.get(mid));
        node.left = constructTree(lower, mid, myList);
        node.right = constructTree(mid+1, upper, myList);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> myList = new ArrayList<>();
        populateList(root, myList);
        Collections.sort(myList);

        return constructTree(0, myList.size(), myList);
    }
}