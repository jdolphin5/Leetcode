class Solution {
    private boolean helper(int[] ret, int[] matchsticks, int i, int sideLen) {
        if (ret[0] == sideLen && ret[1] == sideLen && ret[2] == sideLen && ret[3] == sideLen)
            return true;

        if (i == matchsticks.length)
            return false;
        
        for (int j = 0; j < 4; j++) {
            if (ret[j] > sideLen)
                return false;
            ret[j] += matchsticks[i];
            if (helper(ret, matchsticks, i+1, sideLen))
                return true;
            ret[j] -= matchsticks[i];
            if (ret[j] == 0) return false; //the number couldn't be placed
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        
        for (int num : matchsticks) {
            total += num;
        }

        if (total % 4 != 0) return false;

        int sideLen = total / 4;

        Arrays.sort(matchsticks); //sort ascending
        int[] reversed = new int[matchsticks.length];
        Arrays.setAll(reversed, i -> matchsticks[matchsticks.length-i-1]);
        //reverse to descending order

        int[] ret = new int[4];
        
        return helper(ret, reversed, 0, sideLen);
    }
}