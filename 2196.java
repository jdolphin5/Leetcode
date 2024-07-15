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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> myMap = new HashMap<>();
        List<Integer> childList = new ArrayList<>();

        for (int[] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            TreeNode parentNode = myMap.getOrDefault(parent, new TreeNode(parent));
            
            if (isLeft == 1) {
                TreeNode leftChild = myMap.getOrDefault(child, new TreeNode(child));
                myMap.put(child, leftChild);
                parentNode.left = leftChild;
            }
            else {
                TreeNode rightChild = myMap.getOrDefault(child, new TreeNode(child));
                myMap.put(child, rightChild);
                parentNode.right = rightChild;
            }

            childList.add(child);
            myMap.put(parent, parentNode);
        }

        for (Map.Entry<Integer, TreeNode> entry : myMap.entrySet()) {
            if (!childList.contains(entry.getKey()))
                return myMap.get(entry.getKey());
        }

        return null;
    }
}