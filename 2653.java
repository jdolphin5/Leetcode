class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] bucket = new int[101];
        int[] result = new int[nums.length-k+1];
        
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]+50]++;
            if (i >= k-1) {
                int c = 0;
                
                for (int j = 0; j < 50; j++) {
                    if ((c += bucket[j]) >= x) {
                        result[i-k+1] = j-50;
                        break;
                    }
                }
                bucket[nums[i-k+1]+50]--;
            }
            
        }
        return result;
    }
}