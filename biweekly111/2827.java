class Solution {
    private void resetDp(int[][][][][] dp) {
        for (int[][][][] arr1 : dp) {
            for (int[][][] arr2 : arr1) {
                for (int[][] arr3 : arr2) {
                    for (int[] arr4 : arr3) {
                        Arrays.fill(arr4, -1);
                    }
                }
            }
        }
    }
    
    private int digitDp(int[][][][][] dp, String number, int x, int even, int odd, int tight, String cur, int k, int rem, int isZero) {
        //System.out.println("x: " + x + " cur: " + cur);

        if (number.length() == x) {
            if (even == odd && rem == 0) {
                return 1;
            }
            return 0;
        }
        
        if (dp[x][tight][even][odd][rem] != -1) {
            return dp[x][tight][even][odd][rem];
        }
        
        int limit = 9;
        if (tight == 1) {
            limit = number.charAt(x)-'0';
        }
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            int nextRem = (rem*10 + i) % k;
            boolean isEven = false;
            boolean isOdd = false;
            
            int nextTight = 0;
            if (tight == 1 && i == limit) {
                nextTight = 1;
            }
            int nextZero = 0;
            if (isZero == 1 && i == 0) {
                nextZero = 1;
            }
            
            if (i % 2 == 0) {
                if (nextZero != 1)
                    isEven = true;
            }
            else {
                isOdd = true;
            }
            
            ans += digitDp(dp, number, x+1, even+(isEven?1:0), odd+(isOdd?1:0), nextTight, cur+i, k, nextRem, nextZero);
            
        }
        
        return dp[x][tight][even][odd][rem] = ans;
        
    }
    
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        
        int[][][][][] dp = new int[11][2][11][11][21];
        resetDp(dp);
        int highCount = digitDp(dp, String.valueOf(high), 0, 0, 0, 1, "", k, 0, 1);
        resetDp(dp);
        int lowCount = digitDp(dp, String.valueOf(low-1), 0, 0, 0, 1, "", k, 0, 1);
        
        int ret = highCount - lowCount;
        
        System.out.println(highCount);
        System.out.println(lowCount);
        
        
        return ret;
        
    }
}