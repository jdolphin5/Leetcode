class Solution {

    private boolean traverse(int[] dp, int i, boolean[] visited) {
        if (i < 0) return false;
        if (i >= dp.length) return true; //boundary checking

        if (visited[i] == true) return false;
        if (dp[i] == dp.length-1) return true;

        visited[i] = true;

        for (int j = dp[i]; j >= 1; j--) {
            if (traverse(dp, j, visited)) return true;
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int[] dp = new int[nums.length];

        for (int i = nums.length-1; i >= 0; i--) {
            dp[i] = i + nums[i];
        }
        if (dp[nums.length-1] == 0) return true;

        boolean[] visited = new boolean[nums.length];

        return traverse(dp, 0, visited);
    }
}