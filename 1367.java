/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean isSubPathExtraParam(ListNode head, TreeNode root, boolean started) {
        if (head == null)
            return true;

        if (root == null)
            return false;

        boolean ret = false;

        if (head.val == root.val)
            ret |= isSubPathExtraParam(head.next, root.left, true) || isSubPathExtraParam(head.next, root.right, true);
        
        //only call from each node in tree once
        if (!started)
            ret |= isSubPathExtraParam(head, root.left, false) || isSubPathExtraParam(head, root.right, false);

        return ret;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return isSubPathExtraParam(head, root, false);
    }
}