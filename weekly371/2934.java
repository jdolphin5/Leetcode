class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        //try no swap
        int nums1Max = nums1[nums1.length-1];
        int nums2Max = nums2[nums2.length-1];
        
        int ret = Integer.MAX_VALUE;
        int noSwapCt = 0;
        int i = nums1.length-2;
        
        for (; i >= 0; i--) {
            if (nums1[i] <= nums1Max && nums2[i] <= nums2Max) {
                continue;
            }
            else {
                //try swap
                if (nums1[i] <= nums2Max && nums2[i] <= nums1Max) {
                    noSwapCt++;
                    continue;
                }
                else {
                    break;
                }
            }
        }
        
        if (i == -1) {
            ret = Math.min(ret, noSwapCt);
        }
        
        int swapCt = 1;
        i = nums1.length-2;
        
        int temp = nums1Max;
        nums1Max = nums2Max;
        nums2Max = temp;
        
        for (; i >= 0; i--) {
            if (nums1[i] <= nums1Max && nums2[i] <= nums2Max) {
                
            }
            else {
                //try swap
                if (nums1[i] <= nums2Max && nums2[i] <= nums1Max) {
                    swapCt++;
                }
                else {
                    break;
                }
            }
        }
        
        if (i == -1) {
            ret = Math.min(ret, swapCt);
        }
        
        
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}