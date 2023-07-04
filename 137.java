class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> notGood = new HashSet<>();
        Set<Integer> maybeGood = new HashSet<>();
        for (int num : nums) {
            if (maybeGood.contains(num)) notGood.add(num);
            maybeGood.add(num);
        }
        for (int num : nums) {
            if (!notGood.contains(num)) {
                return num;
            }
        }
        return 0;
    }
}