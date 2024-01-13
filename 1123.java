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
    private void generateParents(Map<TreeNode, TreeNode> parentMap, TreeNode root, TreeNode parent) {
        if (root == null) return;

        if (parent != null) {
            parentMap.put(root, parent);
        }

        generateParents(parentMap, root.left, root);
        generateParents(parentMap, root.right, root);
    }

    private void generateDepthMap(Map<Integer, List<TreeNode>> depthMap, int depth, TreeNode root) {
        if (root == null) return;

        List<TreeNode> myList = depthMap.getOrDefault(depth, new ArrayList<>());
        myList.add(root);
        depthMap.put(depth, myList);

        generateDepthMap(depthMap, depth+1, root.left);
        generateDepthMap(depthMap, depth+1, root.right);
    }

    private TreeNode findLCA(List<TreeNode> maxDepthList, Map<TreeNode, TreeNode> parentMap, TreeNode node, List<TreeNode> visited) {
        if (visited.contains(node)) return null;

        visited.add(node);

        if (maxDepthList.contains(node)) {
            maxDepthList.remove(node);
        }

        if (node.left != null) {
            findLCA(maxDepthList, parentMap, node.left, visited);
        }
        if (node.right != null) {
            findLCA(maxDepthList, parentMap, node.right, visited);
        }

        if (parentMap.get(node) == null || maxDepthList.size() == 0) return node;

        return findLCA(maxDepthList, parentMap, parentMap.get(node), visited);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        generateParents(parentMap, root, null);

        Map<Integer, List<TreeNode>> depthMap = new HashMap<>();
        generateDepthMap(depthMap, 0, root);

        int maxDepth = depthMap.size()-1;
        List<TreeNode> maxDepthList = depthMap.get(maxDepth);
        TreeNode start = maxDepthList.get(0);
        List<TreeNode> visited = new ArrayList<>();

        return findLCA(maxDepthList, parentMap, start, visited);
    }
}