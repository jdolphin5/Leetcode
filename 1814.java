class Solution {
    public int countNicePairs(int[] nums) {
        // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) ==>
        // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        // 2 indices same value - 1 pair - 1
        // 3 indices same value - 3 pairs - 2+1
        // 4 indices same value - 6 pairs - 3+2+1
        // 5 indices same value - 1 2 3 4 5 -- 4+3+2+1 - 10
        // map of values to count of indices

        Map<Integer, Integer> myMap = new HashMap<>();
        final int MOD = 1000000007;
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String numString = String.valueOf(num);
            StringBuilder numStringSB = new StringBuilder(numString);
            numStringSB.reverse();
            int revNum = Integer.parseInt(new String(numStringSB));
            int total = num - revNum;
            myMap.put(total, myMap.getOrDefault(total, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            int toAdd = 0;

            for (int i = count-1; i >= 1; i--) {
                toAdd += i;
                toAdd %= MOD;
            }

            ret += toAdd;
            ret %= MOD;
        }

        return ret;
    }
}