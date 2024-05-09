class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long ret = 0;
        int i = happiness.length-1;

        while (i >= happiness.length-k) {
            ret += Math.max(0, happiness[i] - (happiness.length-1 - i));    
            i--;
        }

        return ret;
    }
}