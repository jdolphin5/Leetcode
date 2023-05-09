class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> mySet = new HashSet<>();
        int sum = 0;
        int count = 0;

        for (int i = 0; i < banned.length; i++) {
            mySet.add(banned[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!mySet.contains(i)) {
                sum += i;
                if (sum > maxSum) break;
                count++;
            }
        }
        return count;

    }
}