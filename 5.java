class Solution {

    private int[] findLengthPal(String s, int i, int j, int[] res) {
        if (i < 0 || j < 0 || i >= s.length() || j >= s.length() || s.charAt(i) != s.charAt(j)) return res;

        res[0] = j-i+1;
        res[1] = i;
        res[2] = j;

        return findLengthPal(s, i-1, j+1, res);
    }

    public String longestPalindrome(String s) {
        int[] maxRes = new int[3];

        for (int i = 0; i < s.length(); i++) {
            int[] res = new int[3];
            
            res = findLengthPal(s, i, i, res);
            if (res[0] > maxRes[0]) {
                maxRes = res.clone();
            }
            res = findLengthPal(s, i, i+1, res);
            if (res[0] > maxRes[0]) {
                maxRes = res.clone();
            }
        }

        return s.substring(maxRes[1], maxRes[2]+1);
    }
}