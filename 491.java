class Solution {
    private void recur(int[] nums, int i, List<Integer> myList, List<List<Integer>> ret, int last) {
        if (i == nums.length) {
            return;
        }

        Set<Integer> seen = new HashSet<>();

        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] >= last && !seen.contains(nums[j])) {
                myList.add(nums[j]);
                if (myList.size() >= 2)
                    ret.add(new ArrayList<>(myList));
                recur(nums, j, myList, ret, nums[j]);
                myList.remove(myList.size()-1);
            }

            seen.add(nums[j]);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> myList = new ArrayList<>();

        recur(nums, -1, myList, ret, -101);

        return ret;
    }
}