class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] cache = new Integer[target + 1];
        return backtrack(nums, target, cache);
    }

    public int backtrack(int[] nums, int remain, Integer[] cache) {

        if (remain < 0) return 0;
        if (cache[remain] != null) return cache[remain];
        if (remain == 0) return 1;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += backtrack(nums, remain - nums[i], cache);
        }

        cache[remain] = ans;
        return cache[remain];
    }
}