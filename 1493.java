class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = -1;
        int cur = 0;
        int max = 0;
        boolean zeroFound = false;
        while (cur < nums.length) {
            if (nums[cur] == 0) {
                zeroFound = true;
                if (j != -1) {
                    i = j+1;
                    j = cur;
                }
                else {
                    j = cur;
                }
            }
            else {
                int offset = zeroFound ? 1 : 0;
                max = Math.max(cur - i + 1 - offset, max);
                if (!zeroFound && cur == nums.length-1) max--;
                //System.out.println("i: " + i + " j: " + j + " cur: " + cur);
            }
            cur++;
        }

        return max;

    }
}