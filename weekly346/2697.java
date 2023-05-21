class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        for (int i = 0; i < n/2; i++) {
            if (sArr[i] > sArr[n-1-i]) {
                sArr[i] = sArr[n-1-i];
            }
            else if (sArr[i] < sArr[n-1-i]) {
                sArr[n-1-i] = sArr[i];
            }
        }
        return String.valueOf(sArr);
    }
}