class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        int root = copy[0];
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        Map<Integer, Integer> rootMap = new HashMap<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(root);
        myMap.put(root, cur);
        rootMap.put(root, root);
        
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] - copy[i-1] <= limit) {
                List<Integer> myList = myMap.get(root);
                myList.add(copy[i]);
                myMap.put(root, myList);
            }
            else {
                root = copy[i];
                List<Integer> myList = new ArrayList<>();
                myList.add(root);
                myMap.put(root, myList);
            }
            rootMap.put(copy[i], root);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : myMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            myMap.put(key, list);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int key = rootMap.get(nums[i]);
            List<Integer> myList = myMap.get(key);
            int val = myList.get(0);
            nums[i] = val;
            myList.remove(0);
            myMap.put(key, myList);
        }
        
        return nums;
        
    }
}