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

    private int checkGood(int res, List<Integer> myList, TreeNode root) {
        if (root == null) return res;

        boolean good = true;
        
        for (Integer num : myList) {
            if (root.val < num) good = false;
        }

        if (good) {
            myList.add(root.val);
            res++;
        }

        res = checkGood(res, myList, root.left);
        res = checkGood(res, myList, root.right);

        if (good) {
            myList.remove(Integer.valueOf(root.val));
        }

        return res;

    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        int res = 1;
        List<Integer> myList = new ArrayList<>();
        myList.add(root.val);

        res = checkGood(res, myList, root.left);
        res = checkGood(res, myList, root.right);

        return res;

    }
}