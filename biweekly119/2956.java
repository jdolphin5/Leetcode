class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        
        for (int num : nums1) {
            nums1Set.add(num);
        }
        
        for (int num : nums2) {
            nums2Set.add(num);
        }
        
        int ret1 = 0;
        int ret2 = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            if (nums2Set.contains(nums1[i])) {
                ret1++;
            }
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                ret2++;
            }
        }
        
        return new int[] { ret1, ret2 };
        
    }
}