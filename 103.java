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

    private void recur(List<List<Integer>> rawRet, int height, TreeNode root) {
        if (root == null) return;

        if (rawRet.size() < height+1) {
            rawRet.add(new ArrayList<>());
        }
        List<Integer> cur = rawRet.get(height);
        cur.add(root.val);
        rawRet.add(height+1, cur);
        rawRet.remove(height);
        recur(rawRet, height+1, root.left);
        recur(rawRet, height+1, root.right);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rawRet = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        recur(rawRet, 0, root);

        int i = 0;

        for (List<Integer> cur : rawRet) {
            if (i % 2 == 1) {
                Collections.reverse(cur);
            }
            i++;
            ret.add(cur);
        }
        return ret;
    }
}