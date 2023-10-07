class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int j = 0;
        int curCost = 0;
        int maxLen = 0;

        while (j < t.length()) {
            if (curCost > maxCost) {
                curCost -= Math.abs((int)(s.charAt(i)-t.charAt(i)));
                i++;
            }
            else {
                curCost += Math.abs((int)(s.charAt(j)-t.charAt(j)));
                j++;
            }

            if (curCost <= maxCost) {
                maxLen = Math.max(maxLen, j - i);
            }
        }

        return maxLen;
    }
}