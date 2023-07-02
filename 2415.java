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
    private TreeNode reverse(TreeNode root, List<Integer> myList, int depth) {
        if (depth % 2 == 1) {
            root.val = myList.get(0);
            myList.remove(0);
        }
        if (root.right != null) {
            root.right = reverse(root.right, myList, depth+1);
        }
        if (root.left != null) {
            root.left = reverse(root.left, myList, depth+1);
        }

        return root;
    }

    private List<Integer> collectOddNumbers(TreeNode root, List<Integer> myList, int depth) {
        if (depth % 2 == 1) {
            myList.add(root.val);
        }
        if (root.left != null) {
            myList = collectOddNumbers(root.left, myList, depth+1);
        }
        if (root.right != null) {
            myList = collectOddNumbers(root.right, myList, depth+1);
        }
        return myList;
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        List<Integer> myList = new ArrayList<>();
        myList = collectOddNumbers(root, myList, 0);
        TreeNode reversedRoot = reverse(root, myList, 0);

        return reversedRoot;
    }
}