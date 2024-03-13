/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void populateParentMap(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
        if (root == null) return;
        
        if (root.left != null) {
            parentMap.put(root.left, root);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
        }

        populateParentMap(parentMap, root.left);
        populateParentMap(parentMap, root.right);
    }

    private List<Integer> findNodes(TreeNode root, Set<TreeNode> seenSet, int k, Map<TreeNode, TreeNode> parentMap) {
        List<Integer> retList = new ArrayList<>();
        if (root == null || seenSet.contains(root)) return retList;

        seenSet.add(root);

        if (k > 0) {
            retList.addAll(findNodes(parentMap.get(root), seenSet, k-1, parentMap));

            if (root.left != null) {
                retList.addAll(findNodes(root.left, seenSet, k-1, parentMap));
            }
            if (root.right != null) {
                retList.addAll(findNodes(root.right, seenSet, k-1, parentMap));
            }
        }
        else {
            retList.add(root.val);
        }

        return retList;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParentMap(parentMap, root);

        return findNodes(target, new HashSet<>(), k, parentMap);
    }
}