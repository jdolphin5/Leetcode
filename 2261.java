class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int ret = 0;
        Set<String> countedSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int ct = 0;

            StringBuilder hash = new StringBuilder();

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    ct++;
                }

                hash.append(nums[j] + "-");

                if (ct <= k) {
                    countedSet.add(hash.toString());
                }
                else {
                    break;
                }
            }
        }

        return countedSet.size();
    }
}