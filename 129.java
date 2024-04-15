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
    private void recur(List<String> myList, TreeNode root, StringBuilder s) {
        if (root == null) {
            return;
        }

        s.append(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            myList.add(new String(s));
        }

        recur(myList, root.left, s);
        recur(myList, root.right, s);

        s.deleteCharAt(s.length()-1);
    }

    public int sumNumbers(TreeNode root) {
        int ret = 0;
        List<String> retList = new ArrayList<>();
        recur(retList, root, new StringBuilder());
        
        for (String s : retList) {
            ret += Integer.parseInt(s);
        }

        return ret;
    }
}