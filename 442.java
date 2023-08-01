class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        Set<Integer> checkDuplicateSet = new HashSet<>();
        List<Integer> ret = new ArrayList<>();

        for (int num : nums) {
            if (checkDuplicateSet.contains(num))
                ret.add(num);
            else
                checkDuplicateSet.add(num);
        }
        
        return ret;
    }
}