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
        int numOfAverageEqualInSubtree;

        public TreeNodePair(int val, TreeNodePair left, TreeNodePair right, int sumOfNodesInSubtree, int countOfNodesInSubtree, int numOfAverageEqualInSubtree) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.sumOfNodesInSubtree = sumOfNodesInSubtree;
            this.countOfNodesInSubtree = countOfNodesInSubtree;
            this.numOfAverageEqualInSubtree = numOfAverageEqualInSubtree;
        }
    }

    private TreeNodePair populateTreeNodePairs(TreeNode root) {
        if (root == null) {
            return null;
        }

        int totalNodesInSubtree = 1;
        int sum = root.val;
        int count = 0;

        TreeNodePair left = populateTreeNodePairs(root.left);
        TreeNodePair right = populateTreeNodePairs(root.right);

        if (left != null) {
            sum += left.sumOfNodesInSubtree;
            totalNodesInSubtree += left.countOfNodesInSubtree;
            count += left.numOfAverageEqualInSubtree;
        }

        if (right != null) {
            sum += right.sumOfNodesInSubtree;
            totalNodesInSubtree += right.countOfNodesInSubtree;
            count += right.numOfAverageEqualInSubtree;
        }

        count += sum / totalNodesInSubtree == root.val ? 1 : 0;

        return new TreeNodePair(root.val, left, right, sum, totalNodesInSubtree, count);
    }

    public int averageOfSubtree(TreeNode root) {
        TreeNodePair rootTreeNodePair = populateTreeNodePairs(root);

        return rootTreeNodePair.numOfAverageEqualInSubtree;
    }
}