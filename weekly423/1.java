class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i < nums.size() - (2 * k) + 1; i++) {
            boolean a = true;

            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    a = false;
                    break;
                }
            }

            boolean b = true;

            for (int j = i + k + 1; j < i + (2 * k); j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    b = false;
                    break;
                }
            }

            if (a && b) {
                return true;
            }
        }

        return false;
    }
}