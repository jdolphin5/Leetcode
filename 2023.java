class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                String comp = nums[i] + nums[j];
                if (comp.equals(target)) count++;
            }
        }
        return count;
    }
}

// "777" "7"
// i = 0 j = 1 => "777" + "7"
// j = 0 i = 1 => "7" + "777"