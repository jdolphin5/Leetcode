class Solution {
    public int minOperations(int k) {
        int ret = k-1;
        int cur = 1;
        //System.out.println("p");
        
        while (cur < k) {
            double d = Math.ceil((double)k / cur);
            ret = Math.min(ret, cur-1 + (int)(d)-1);
            //System.out.println("cur: " + cur + " ret: " + ret);
            cur++;
        }
        
        return ret;
        
    }
}