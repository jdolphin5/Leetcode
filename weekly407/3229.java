class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int last = 0;
        long ret = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - target[i];
            
            if (diff > 0) {
                if (diff > last) {
                    last = Math.max(0, last);
                    ret += diff - last;
                }
            }
            else if (diff < 0) {
                if (diff < last) {
                    last = Math.min(0, last);
                    ret += Math.abs(last - diff);
                }
            }
            else {
                diff = 0;
            }

            last = diff;

            //System.out.println(ret);
        }

        return ret;
    }
}