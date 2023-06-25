class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long ret = 0;
        final int MOD = 1000000007;
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1)
                q.offer(i);
            i++;
        }
        int prev = 0;
        if (!q.isEmpty()) {
            prev = q.poll();
            ret++;
        }
        while (!q.isEmpty()) {
            int pop = q.poll();
            ret += (pop-prev-1) * ret;
            ret %= MOD;
            prev = pop;
        }
        return (int)ret % MOD;
    }
}