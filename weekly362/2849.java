class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        if (sx == fx && sy == fy) {
            if (t == 0 || t >= 2) {
                return true;
            }
            return false;
        }
        
        int xDiff = Math.abs(fx - sx);
        int yDiff = Math.abs(sy - fy);
        
        int diag = Math.min(xDiff, yDiff);
        
        int time = 0;
        
        time += diag;
        
        xDiff -= diag;
        yDiff -= diag;
        
        time += xDiff;
        time += yDiff;
        
        return time <= t;
         
    }
}