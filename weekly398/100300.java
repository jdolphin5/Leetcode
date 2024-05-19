class Solution {
    public long sumDigitDifferences(int[] nums) {
        long ret = 0;
        
        int[][] numCountArr = new int[10][10];
        
        for (int num : nums) {
            int i = 0;
            
            while (num > 0) {
                numCountArr[i][num % 10]++;
                num /= 10;
                i++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {
                for (int x = 0; x < 10; x++) {
                    long toAdd = (numCountArr[x][i] * numCountArr[x][j]) * 1L;
                    if (toAdd > 0) ret += toAdd;
                }
            }
        }
        
        return ret;
    }
}