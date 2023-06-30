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
            if (isEven[queries[i][1]])
                sum -= nums[queries[i][1]];
            boolean queryEven = false;
            if (queries[i][0] % 2 == 0) {
                queryEven = true;
            }
            nums[queries[i][1]] += queries[i][0];
            if ((queryEven && isEven[queries[i][1]]) || (!queryEven && !isEven[queries[i][1]])) {
                sum += nums[queries[i][1]];
                isEven[queries[i][1]] = true;
            }
            else {
                isEven[queries[i][1]] = false;
            }
            answer[i] = sum;
            //System.out.println(Arrays.toString(nums));
        }
        return answer;
    }
}