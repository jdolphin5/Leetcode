class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        boolean[] isEven = new boolean[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                isEven[i] = true;
                sum += nums[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int queryIndex = queries[i][1];
            int queryVal = queries[i][0];
            if (isEven[queryIndex])
                sum -= nums[queryIndex];
            boolean queryEven = false;
            if (queryVal % 2 == 0) {
                queryEven = true;
            }
            nums[queryIndex] += queryVal;
            if ((queryEven && isEven[queryIndex]) || (!queryEven && !isEven[queryIndex])) {
                sum += nums[queryIndex];
                isEven[queryIndex] = true;
            }
            else {
                isEven[queryIndex] = false;
            }
            answer[i] = sum;
        }
        return answer;
    }
}