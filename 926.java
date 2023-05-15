class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] charArr = s.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        for (char myChar : charArr) {
            if (oneCount == 0 && myChar == '0') continue;
            if (myChar == '1') oneCount++;
            else if (myChar == '0') zeroCount++;
            if (zeroCount > oneCount) zeroCount = oneCount;
        }
        return zeroCount;
    }
}