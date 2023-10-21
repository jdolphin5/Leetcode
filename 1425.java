class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        int ret = nums[0]; //init with first value of nums arr as max may be < 0

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dp[b] - dp[a]); //desc order of dp values
        pq.offer(0);

        for (int i = 1; i < nums.length; i++) {
            int diff = Math.max(i-k, 0);
            
            while (!pq.isEmpty() && pq.peek() < diff) {
                pq.poll();
            }

            //take maximum value of dp[x] within range of x = i-k to x = i-1 because i has not been added to pq yet
            int idx = pq.peek();

            dp[i] = Math.max(dp[idx] + nums[i], nums[i]);
            ret = Math.max(ret, dp[i]);
            pq.offer(i);
        }

        return ret;
    }
}