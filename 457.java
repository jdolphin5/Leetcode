class Solution {
    private int dp(int[] cycles, int[] nums, int num, int k, boolean sign, boolean[] visited, int lastNum) {
        int val = num;
        
        //adjust num such that it is within the range of 0 : nums.length-1
        while (val < 0) {
            val = (val+nums.length) % nums.length;
        }
        if (val >= nums.length) {
            val = val % nums.length;
        }

        if ((nums[val] < 0 && sign) || (nums[val] > 0 && !sign)) { //diff sign from last num so no cycle
            return -1;
        }

        if (visited[val]) {
            if (cycles[val] == -1) return -1;
            if (lastNum != val) {
                return k;
            }
            return 1;
        }

        if (cycles[val] != -2) {
            return cycles[val];
        }

        visited[val] = true;
        return cycles[val] = dp(cycles, nums, val+nums[val], k+1, sign, visited, val);
    }

    public boolean circularArrayLoop(int[] nums) {
        int[] cycles = new int[nums.length];
        Arrays.fill(cycles, -2);

        for (int i = 0; i < nums.length; i++) {
            boolean[] visited = new boolean[nums.length];
            visited[i] = true;
            int val = dp(cycles, nums, i+nums[i], 1, nums[i] > 0, visited, Integer.MIN_VALUE);
            if (val > 1) return true;
        }
        return false;
    }
}