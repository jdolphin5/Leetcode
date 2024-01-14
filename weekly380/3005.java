class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] bucket = new int[101];
        
        for (int num : nums) {
            bucket[num]++;
        }
        
        Arrays.sort(bucket);
        
        int max = bucket[100];
        
        int i = 100;
        int ret = 0;
        
        while (i >= 0 && bucket[i] == max) {
            ret += max;
            i--;
        }
        
        return ret;
    }
}