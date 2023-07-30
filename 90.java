class Solution {

    private void recur(int[] nums, int i, List<List<Integer>> ret, List<Integer> curList) {
        if (i >= nums.length) {
            return;
        }
        recur(nums, i+1, ret, curList);
        List<Integer> newList = new ArrayList<>();
        for (int num : curList) {
            newList.add(num);
        }
        newList.add(nums[i]);
        Collections.sort(newList);
        ret.add(newList);
        recur(nums, i+1, ret, newList);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        ret.add(curList);

        recur(nums, 0, ret, new ArrayList<>());

        Set<List<Integer>> mySet = new HashSet<>(ret);
        ret = new ArrayList<>(mySet);

        return ret;
    }
}