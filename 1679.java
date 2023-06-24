class Solution {
    public int maxOperations(int[] nums, int k) {
        int remain = nums.length;
        int count = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        Set<Integer> mySet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i], myMap.getOrDefault(nums[i], 0) + 1);
            mySet.add(nums[i]);
        }

        for (Integer x : mySet) {
            if (x != k-x && myMap.containsKey(k-x)) {
                int min = Math.min(myMap.get(x), myMap.get(k-x));
                count += min;
                myMap.put(x, myMap.get(x)-min);
                myMap.put(k-x, myMap.get(k-x)-min);
                if (k == x + x) {
                    count += myMap.get(x)/2;
                }
                if (k == (k-x)+(k-x)) {
                    count += myMap.get(k-x)/2;
                }
                myMap.remove(x);
                myMap.remove(k-x);
            }
            else if (x == k-x) {
                if (k == x + x) {
                    count += myMap.get(x)/2;
                }
                myMap.remove(x);
            }
        }
        return count;
    }
}