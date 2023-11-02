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
    public class TreeNodePair {
        int val;
        int sumOfNodesInSubtree;
        int countOfNodesInSubtree;
        TreeNodePair left;
        TreeNodePair right;

        public TreeNodePair(int val, TreeNodePair left, TreeNodePair right, int sumOfNodesInSubtree, int countOfNodesInSubtree) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.sumOfNodesInSubtree = sumOfNodesInSubtree;
            this.countOfNodesInSubtree = countOfNodesInSubtree;
        }
    }

    private TreeNodePair populateTreeNodePairs(TreeNode root) {
        if (root == null) {
            return null;
        }

        int totalNodesInSubtree = 1;
        int sum = root.val;

        TreeNodePair left = populateTreeNodePairs(root.left);
        TreeNodePair right = populateTreeNodePairs(root.right);

        if (left != null) {
            sum += left.sumOfNodesInSubtree;
            totalNodesInSubtree += left.countOfNodesInSubtree;
        }

        if (right != null) {
            sum += right.sumOfNodesInSubtree;
            totalNodesInSubtree += right.countOfNodesInSubtree;
        }

        return new TreeNodePair(root.val, left, right, sum, totalNodesInSubtree);
    }

    private int traverseForResult(TreeNodePair rootTreeNodePair) {
        if (rootTreeNodePair == null) {
            return 0;
        }

        int ret = 0;

        int left = traverseForResult(rootTreeNodePair.left);
        int right = traverseForResult(rootTreeNodePair.right);

        if (rootTreeNodePair.sumOfNodesInSubtree/rootTreeNodePair.countOfNodesInSubtree == rootTreeNodePair.val) {
            ret++;
        }

        return ret + left + right;
    }

    public int averageOfSubtree(TreeNode root) {
        TreeNodePair rootTreeNodePair = populateTreeNodePairs(root);

        return traverseForResult(rootTreeNodePair);
    }
}