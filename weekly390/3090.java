class Solution {
    private boolean good(int[] bucket) {
        for (int num : bucket) {
            if (num > 2) return false;
        }
        
        return true;
    }
    
    public int maximumLengthSubstring(String s) {
        //System.out.println("p");
        
        int[] bucket = new int[26];
        int ret = 0;
        
        int i = 0;
        int j = 0;
        
        while (j <= s.length()) {
            if (good(bucket)) {
                if (j < s.length())
                    bucket[s.charAt(j)-'a']++;
                ret = Math.max(ret, j - i);
                j++;
            }
            else {
                bucket[s.charAt(i)-'a']--;
                i++;
            }
            
            //System.out.println("i: " + i + " j: " + j);
        }
        
        return ret;
    }
}