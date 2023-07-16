class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int[] bucket = new int[100001];
        for (int num : nums) {
            bucket[num]++;
        }
        
        int sum = 0;
        int max = 0;
        
        for (int x = 0; x < 100001; x++) {
            sum += bucket[x];
            if (x > 2*k) {
                sum -= bucket[x-2*k-1];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}