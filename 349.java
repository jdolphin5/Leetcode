class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> retSet = new HashSet<>();
        Set<Integer> nums1Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                retSet.add(nums2[i]);
            }
        }

        int[] ret = new int[retSet.size()];
        int i = 0;

        for (int num : retSet) {
            ret[i++] = num;
        }

        return ret;
    }
}