class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) { 
        int curLen = 1;
        int maxHorizontalLen = 1;
        int maxVerticalLen = 1;
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        
        for (int i = 0; i < hBars.length; i++) {
            if (i > 0 && hBars[i-1] == hBars[i]-1) {
                curLen++;
            }
            else {
                curLen = 2;
            }
            maxHorizontalLen = Math.max(maxHorizontalLen, curLen);
        }
        
        
        curLen = 1;
        
        for (int i = 0; i < vBars.length; i++) {
            if (i > 0 && vBars[i-1] == vBars[i]-1) {
                curLen++;
            }
            else {
                curLen = 2;
            }
            maxVerticalLen = Math.max(maxVerticalLen, curLen);
        }
        
        int ret = 0;
        
        ret = Math.min(maxVerticalLen, maxHorizontalLen);
        ret *= ret;
        
        
        return ret;
    }
}