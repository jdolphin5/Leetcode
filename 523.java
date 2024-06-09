class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> pastSums = new HashMap<>();
        int sum = 0;

        pastSums.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (pastSums.containsKey(sum % k)) {
                if ((i - pastSums.get(sum % k)) >= 2) {
                    return true;
                }
            }
            else
                pastSums.put(sum % k, i);

            //System.out.println(pastSums.toString());
        }

        return false;
    }
}