class Solution {
    public long minimumPossibleSum(int n, int target) {
        long sum = 0;
        Set<Integer> mySet = new HashSet<>();
        int i = 1;
        int j = 0;
        while (j < n) {
            if (mySet.contains(target-i)) {
                i++;
                continue;
            }
            else {
                sum += i;
                mySet.add(i);
                i++;
                j++;
            }
        }
        
        return sum;
    }
}