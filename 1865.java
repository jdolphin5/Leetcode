class FindSumPairs {
    int[] nums1Arr;
    int[] nums2Arr;
    Map<Integer, Integer> myMap;
    int curCount;

    public FindSumPairs(int[] nums1, int[] nums2) {
        nums1Arr = nums1.clone();
        nums2Arr = nums2.clone();
        myMap = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++) {
            myMap.put(nums2[i], myMap.getOrDefault(nums2[i], 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int decVal = nums2Arr[index];
        myMap.put(decVal, myMap.get(decVal)-1);
        nums2Arr[index] += val;
        int incVal = nums2Arr[index];
        myMap.put(incVal, myMap.getOrDefault(incVal, 0) + 1);
    }
    
    public int count(int tot) {
        int ret = 0;
        
        for (int i = 0; i < nums1Arr.length; i++) {
            ret += myMap.getOrDefault(tot-nums1Arr[i], 0);
        }

        return ret;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */