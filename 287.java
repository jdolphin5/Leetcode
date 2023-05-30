class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            if (mySet.contains(num)) return num;
            mySet.add(num);
        }
        return 0;
    }
}