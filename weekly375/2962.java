class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = 0;
        long ret = 0;
        int n = nums.length;
        
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        int i = 0;
        int j = 0;
        int freq = 0;
        
        while (j < nums.length) {
            if (freq < k) {
                if (nums[j] == maxNum) {
                    freq++;
                }
                j++;
            }
            else {
                if (nums[i] == maxNum) {
                    freq--;
                }
                i++;
            }
            
            if (freq >= k) {
                ret += n - (j - 1);
                //System.out.println("i: " + i + " j: " + j + " ret: " + ret);
            }
        
        }
        
        if (nums[i] == maxNum) {
                freq--;
            }
        i++;
        
        while (freq >= k && i < nums.length) {
            if (nums[i] == maxNum) {
                freq--;
            }
            i++;
            ret += n - (j - 1);
        }
        
        return ret;
        
        //2 -> 3, 3 -> 6, 4 -> 10, 5 -> 15
        //(n(n+1)) / 2
        
        //expand while max num freq is less than k - if [i, j] is good, then [i, j+1] -> [i, n] is good
        //shrink until max num freq is less than k again
    }
}