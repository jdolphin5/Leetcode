class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int attemptsPerPig = minutesToTest / minutesToDie;
        int ret = 0;
        int states = 1;
        
        while (states < buckets) {
            states *= (attemptsPerPig + 1);
            ret++;
        }

        return ret;
    }
}