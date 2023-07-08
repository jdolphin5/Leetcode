class Solution {
    public int addRungs(int[] rungs, int dist) {
        int extraRungs = 0;
        for (int i = 0; i < rungs.length; i++) {
            double diff;
            if (i == 0) diff = rungs[i] - 0;
            else  
                diff = rungs[i] - rungs[i-1];
            if (diff > dist) {
                extraRungs += Math.ceil((diff - dist) / dist);
            }
        }
        return extraRungs;
    }
}
