class Solution {
    private int recur(int[] nums, int k, int i, Set<Integer> mySet) {
        if (i == nums.length) {
            if (mySet.size() >= 1)
                return 1;
            return 0;
        }

        int leave = recur(nums, k, i+1, mySet);

        int take = 0;

        if (!mySet.contains(nums[i] - k)) {
            mySet.add(nums[i]);
            take = recur(nums, k, i+1, mySet);
            mySet.remove(nums[i]);
        }

        return leave + take;
    }

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        return recur(nums, k, 0, new HashSet<>());
    }
}