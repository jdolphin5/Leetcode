class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ret = 0;
        
        long total = 0;
        long curMin = Integer.MAX_VALUE;
        long pre = 0;
        
        for (int i = 0; i < maxHeights.size(); i++) {
            
            long peak = maxHeights.get(i);
            long subTotal = peak;
            
            for (int j = i+1; j < maxHeights.size(); j++) {
                peak = Math.min(peak, maxHeights.get(j));
                subTotal += peak;
                //System.out.println(subTotal);
            }
            
            //System.out.println("i: " + i + " pre: " + pre + " subTotal: " + subTotal);
            
            ret = Math.max(ret, pre + subTotal);
            
            pre = 0;
            
            long max = maxHeights.get(i);
            
            for (int x = i; x >= 0; x--) {
                long add = Math.min(max, maxHeights.get(x));
                pre += add;
                max = add;
            }
            
        }
        
        return ret;
    }
}