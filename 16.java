class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        
        int sum = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-2 && diff != 0; i++) {
            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    j++;
                } 
                else {
                    k--;
                }
            }

        }

        return target - diff;
    }
}