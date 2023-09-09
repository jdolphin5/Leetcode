class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int count = 0;

        //merge nums1 and nums2 to 1 array
        //merge nums3 and nums4 to 1 array
        //2sum (complement) those

        int[] nums1AndNums2 = new int[nums1.length*nums2.length];
        int[] nums3AndNums4 = new int[nums3.length*nums4.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                nums1AndNums2[(i*nums1.length)+j] = nums1[i] + nums2[j];
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                nums3AndNums4[(i*nums3.length)+j] = nums3[i] + nums4[j];
            }
        }

        for (int num : nums1AndNums2) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums3AndNums4) {
            if (myMap.containsKey(num*-1)) {
                count += myMap.get(num*-1);
            }
        }

        return count;
    }
}