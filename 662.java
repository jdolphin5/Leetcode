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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> lengths = new LinkedList();

        int result = 0;
        if (root == null) return result;
        
        queue.add(root);
        lengths.add(0);

        while (!queue.isEmpty()) {
            int start = 0;
            int end = 0;
            int size = queue.size();  //set number of items to operate on (one level of TreeNodes)      

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                int length = lengths.remove();
                if (i == 0) start = length;
                if (i == size-1) end = length;
                if (cur.left != null) {
                    queue.add(cur.left);
                    lengths.add(2*length);
                }
                if (cur.right != null) { 
                    queue.add(cur.right);
                    lengths.add((2*length)+1);
                }
            }
            result = Math.max(result, end - start + 1);

        }

        return result;
    }
}