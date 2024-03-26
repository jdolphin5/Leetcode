class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                mySet.add(num);
            }
        }

        for (int i = 1; i <= 100001; i++) {
            if (!mySet.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}