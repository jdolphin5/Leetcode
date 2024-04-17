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
    private void recur (PriorityQueue<String> pq, TreeNode root, StringBuilder s) {
        if (root == null) {
            return;
        }

        s.insert(0, (char)('a' + root.val));

        if (root.left == null && root.right == null) {
            pq.offer(new String(s));
        }

        recur(pq, root.left, s);
        recur(pq, root.right, s);

        s.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
        recur(pq, root, new StringBuilder());

        return pq.peek();
    }
}