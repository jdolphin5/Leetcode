class Solution {

    private int compareCharRetLen(char[] c1, char[] c2, int c1Index, int c2Index, int[][] lArr) {
        if (c1Index >= c1.length || c2Index >= c2.length) {
            return 0;
        }
        if (lArr[c1Index][c2Index] < 0) {
            if (c1[c1Index] == '\0' || c2[c2Index] == '\0' ) { 
                lArr[c1Index][c2Index] = 0;
            }
            else if (c1[c1Index] == c2[c2Index]) {

                lArr[c1Index][c2Index] = 1 + compareCharRetLen(c1, c2, c1Index+1, c2Index+1, lArr);
            }
            else {
                lArr[c1Index][c2Index] = Math.max(compareCharRetLen(c1, c2, c1Index+1, c2Index, lArr),
                compareCharRetLen(c1, c2, c1Index, c2Index+1, lArr));
            }
        }
        return lArr[c1Index][c2Index];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] lArr = new int[c1.length][c2.length];

        for (int m = 0; m < lArr.length; m++) {
            Arrays.fill(lArr[m], -1);
        }

        return compareCharRetLen(c1, c2, 0, 0, lArr);
    }
}