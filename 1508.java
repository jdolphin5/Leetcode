class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> newList = new ArrayList<>();
        long ret = 0;
        final int MOD = 1000000007;
        
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            newList.add(sum);
            for (int j = i+1; j < n; j++) {
                sum += nums[j];
                newList.add(sum);
            }
        }
        Collections.sort(newList);
        for (int i = left-1; i < right; i++) {
            ret += (newList.get(i) + MOD) % MOD;
        }
        return (int)((ret + MOD) % MOD);
    }
}