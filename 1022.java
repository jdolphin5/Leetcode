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

    private int sumPath(TreeNode root, int total, List<Integer> myList) {
        if (root.left == null && root.right == null) {
            myList.add(root.val);
            for (int i = 0; i < myList.size(); i++) {
                total += myList.get(i) * Math.pow(2, (myList.size()-1-i));
            }
            myList.remove(myList.size()-1);
            return total;
        }

        myList.add(root.val);

        if (root.left != null) {
            total = sumPath(root.left, total, myList);
        }
        if (root.right != null) {
            total = sumPath(root.right, total, myList);
        }

        myList.remove(myList.size()-1);

        return total;
    }

    public int sumRootToLeaf(TreeNode root) {
        List<Integer> myList = new ArrayList<>();

        return sumPath(root, 0, myList);
    }
}