class Solution {

    private int checkNum(int num, Set<Integer> mySet, int length) {
        if (!mySet.contains(num)) return 0;

        mySet.remove(num);
        length++;

        if (mySet.contains(num+1)) {
            length = checkNum(num+1, mySet, length);
        }
        if (mySet.contains(num-1)) {
            length = checkNum(num-1, mySet, length);
        }

        return length;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            mySet.add(num);
        }

        for (int num : nums) {
            max = Math.max(max, checkNum(num, mySet, 0));
        }

        return max;
    }
}