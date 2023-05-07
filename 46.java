class Solution {

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else { 
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
}