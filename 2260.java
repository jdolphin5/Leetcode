class Solution {
    public int minimumCardPickup(int[] cards) {
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;

        Set<Integer> mySet = new HashSet<>();

        while (j < cards.length) {
            while (mySet.contains(cards[j])) {
                minLen = Math.min(minLen, j - i + 1);
                mySet.remove(cards[i]);
                i++;
            }
            mySet.add(cards[j]);
            j++;
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;

    }
}