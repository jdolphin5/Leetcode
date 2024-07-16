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
    private void populateMap(Map<TreeNode, TreeNode> parentChildMap, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            parentChildMap.put(root.left, root);
            populateMap(parentChildMap, root.left);
        }

        if (root.right != null) {
            parentChildMap.put(root.right, root);
            populateMap(parentChildMap, root.right);
        }
    }

    private TreeNode findStart(TreeNode root, int startValue) {
        if (root == null) {
            return null;
        }

        if (root.val == startValue) {
            return root;
        }

        TreeNode ret = null;

        if (root.left != null) {
            ret = findStart(root.left, startValue);
        }

        if (ret != null) {
            return ret;
        }

        if (root.right != null) {
            ret = findStart(root.right, startValue);
        }

        return ret;
    }

    private void findDestRoot(Map<TreeNode, TreeNode> parentChildMap, TreeNode root, StringBuilder cur, Set<TreeNode> visited, int destValue, List<String> retList) {
        if (visited.contains(root) || root == null) {
            return;
        }

        if (root.val == destValue) {
            retList.add(new String(cur));
            return;
        }

        visited.add(root);

        if (root.left != null && retList.size() == 0) {
            cur.append("L");
            findDestRoot(parentChildMap, root.left, cur, visited, destValue, retList);
            cur.setLength(cur.length() - 1);
        }

        if (root.right != null && retList.size() == 0) {
            cur.append("R");
            findDestRoot(parentChildMap, root.right, cur, visited, destValue, retList);
            cur.setLength(cur.length() - 1);
        }

        if (parentChildMap.get(root) != null && retList.size() == 0) {
            cur.append("U");
            findDestRoot(parentChildMap, parentChildMap.get(root), cur, visited, destValue, retList);
            cur.setLength(cur.length() - 1);
        }
    }
    

    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();

        populateMap(parentChildMap, root);

        TreeNode startRoot = findStart(root, startValue);

        List<String> retList = new ArrayList<>();

        findDestRoot(parentChildMap, startRoot, new StringBuilder(), new HashSet<>(), destValue, retList);

        return retList.get(0);
    }
}