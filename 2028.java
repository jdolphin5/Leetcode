class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int mSum = 0;
        int m = rolls.length;

        for (int num : rolls) {
            mSum += num;
        }

        int nSum = (mean * (n + m)) - mSum;
        int[] ret = new int[n];
        int rem = nSum;

        for (int i = 0; i < n; i++) {
            for (int j = 6; j >= 1; j--) {
                //cannot divide by zero so n-i-1 > 0
                //try to take the largest number (6) first and see if the remainder is
                //larger than 1 * remainingIndexes
                if (n-i-1 > 0 && ((rem - j) / (n-i-1) > 0)) { 
                    ret[i] = j;
                    rem -= j;
                    break;
                }
                else if (i == n-1) {
                    //if the final remainder is greater than 6 then return empty array
                    if (rem > 6 || rem < 1) return new int[] {};
                    ret[i] = rem;
                    break;
                }
                //if you cannot place any number from 1-6 return empty array
                if (j == 1) return new int[] {};
            }
        }

        return ret;
    }
}