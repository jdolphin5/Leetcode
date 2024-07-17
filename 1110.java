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
    private TreeNode traverse(List<TreeNode> ret, TreeNode root, Set<Integer> toDeleteSet, int depth) {
        if (root == null) {
            return null;
        }

        if (toDeleteSet.contains(root.val)) {
            traverse(ret, root.left, toDeleteSet, 0);
            traverse(ret, root.right, toDeleteSet, 0);

            return null;
        }

        root.left = traverse(ret, root.left, toDeleteSet, depth+1);
        root.right = traverse(ret, root.right, toDeleteSet, depth+1);

        if (depth == 0)
            ret.add(root);

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ret = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();

        for (int x : to_delete) {
            toDeleteSet.add(x);
        }

        traverse(ret, root, toDeleteSet, 0);

        return ret;
    }
}