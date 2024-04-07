class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder ret = new StringBuilder();
        
        //System.out.println("hi");
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            
            if (k == 0) {
                ret.append((char)(c+'a'));
                //System.out.println("stay");
                continue;
            }
            
            int forward = Math.min(c, k);
            int backward = 'z'+1-('a'+c);
            
            char x = (char)('a'+c-forward);
            char y = (char)('a');
            
            //System.out.println("forward: " + forward + "x: " + x + " backward: " + backward + " y: " + y);
            
            if (forward < backward) {
                ret.append(x);
                k -= forward;
            }
            else if (k >= backward && backward <= forward) {
                ret.append(y);
                k -= backward;
            }
            else {
                ret.append(x);
                k -= forward;
            }

            //System.out.println("k: " + k);
        }
        
        return new String(ret);
    }
}