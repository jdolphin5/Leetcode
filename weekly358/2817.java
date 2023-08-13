class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int min = Integer.MAX_VALUE;
        if (x == 0) return 0;
        TreeSet<Integer> myTreeSet = new TreeSet<>();
        myTreeSet.add(Integer.MAX_VALUE);
        myTreeSet.add(Integer.MIN_VALUE);
        
        for (int i = x; i < nums.size(); i++) {
            myTreeSet.add(nums.get(i-x));
            min = Math.min(Math.abs(nums.get(i) - myTreeSet.floor(nums.get(i))), min);
            min = Math.min(Math.abs(myTreeSet.ceiling(nums.get(i)) - nums.get(i)), min);
        }
        
        return min;
        
    }
}