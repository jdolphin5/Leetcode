class Solution {
    private void recur(Set<List<Integer>> retSet, int i, int[] nums, List<Integer> myList) {
        if (i == nums.length) {
            retSet.add(myList);
            return;
        }

        recur(retSet, i+1, nums, myList);
        
        List<Integer> myList2 = new ArrayList<>(myList);
        myList2.add(nums[i]);
        recur(retSet, i+1, nums, myList2);
    }

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> retSet = new HashSet<>();

        recur(retSet, 0, nums, new ArrayList<>());

        return new ArrayList<>(retSet);
    }
}