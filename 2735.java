class Solution {
    public long minCost(int[] nums, int x) {
        
        long minSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            minSum += (long)nums[i];
        }
        
        int[] res = nums.clone();
        int count = 0;
        for (int p = 0; p < nums.length; p++) {
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length-1) {
                    if (nums[nums.length-1] > nums[0]) {
                        res[nums.length-1] = nums[0];
                    }
                }
                else {
                    if (nums[i] > nums[i+1]) {
                        res[i] = nums[i+1];
                    }
                }
            }
            nums = res.clone();
            count++;
            long sum = 0;
            sum += (long)count*(long)x;
            for (int j = 0; j < res.length; j++) {
                sum += (long)res[j];
            }
            //System.out.println(Arrays.toString(res));
            //System.out.println(sum);
            minSum = Math.min(minSum, sum);
            
        }

        return minSum;
        
    }
}