class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        
        char[] charArr = s.toCharArray();
        long res = 0;
        int mod = 1000000007;

        for (int i = 0; i < nums.length; i++) {
            if (charArr[i] == 'R') {
                nums[i] += d;
            }
            else {
                nums[i] -= d;
            }
        }

        Arrays.sort(nums);
        
        long prefix = 0;
        
        for (int i = 0; i < nums.length; i++) {
            res += (long)nums[i]*i - prefix;
            prefix += (long)nums[i];
            res %= mod;
        }
        
        return (int)(res);
        
    }
}