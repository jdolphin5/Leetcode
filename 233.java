class Solution {
    private void resetDp(int[][][] dp) {
        for (int[][] arr1 : dp) {
            for (int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }
    }

    private int digitDp(int[][][] dp, String s, int index, int limit, int lastCount) {
        if (index == s.length()) {
            return lastCount;
        }

        if (dp[index][limit][lastCount] != -1) {
            return dp[index][limit][lastCount];
        }

        int count = 0;
        int ret = 0;

        for (int i = 0; i < 10; i++) {
            int nextLimit = 0;
            if (limit == 1 && s.charAt(index)-'0' == i) {
                nextLimit = 1;
            }
                                //another way to get int from char in string
            if (limit == 1 && i > Character.getNumericValue(s.charAt(index))) { 
                break;
            }
            if (i == 1) {
                count = 1;
            }
            else {
                count = 0;
            }
            
            //System.out.println(" index: " + index + "i: " + i + " count: " + count + " lastCount: " + lastCount + " limit: " + limit);
            ret = ret + digitDp(dp, s, index+1, nextLimit, count+lastCount);
            //System.out.println("ret: " + ret);

        }

        return dp[index][limit][lastCount] = ret;

    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int[][][] dp = new int[10][2][10]; //index, limit, isZero
        resetDp(dp);
        return digitDp(dp, s, 0, 1, 0);
    }
}