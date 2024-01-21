class Solution {
    public int minimumPushes(String word) {
        int[] bucket = new int[26];
        
        for (int i = 0; i < word.length(); i++) {
            bucket[word.charAt(i)-'a']++;
        }
        
        Arrays.sort(bucket);
        
        int i = bucket.length-1;
        
        int ret = 0;
        int mult = 0;
        
        while (i >= 0) {
            mult++;
            
            int cur = i;
            
            for (; i >= Math.max(0, cur-7); i--) {
                ret += mult * bucket[i];
                //System.out.println("i: " + i);
                //System.out.println(ret);
            }
        }
        
        return ret;
        

        
        
    }
}