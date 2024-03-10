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
    private void populateMap(TreeNode root, int height, Map<Integer, List<Integer>> myMap) {
        if (root == null) return;
        
        List<Integer> myList = myMap.getOrDefault(height, new ArrayList<>());
        
        myList.add(root.val);
        myMap.put(height, myList);
        
        populateMap(root.left, height+1, myMap);
        populateMap(root.right, height+1, myMap);
    }
    
    
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        populateMap(root, 0, myMap);
        for (int i = 0; i < myMap.size(); i++) {
            int last = 0;
            List<Integer> myList = myMap.get(i);
            boolean pos = i % 2 == 0;
            for (int j = 0; j < myList.size(); j++) {
                if (pos) {
                    if ((last != 0 && last >= myList.get(j)) || myList.get(j) % 2 == 0) return false;
                }
                else {
                    if ((last != 0 && last <= myList.get(j)) || myList.get(j) % 2 == 1) return false;
                }
                last = myList.get(j);
            }
        }
        
        return true;
    }
}