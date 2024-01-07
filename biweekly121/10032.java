class Solution {
    public int minOperations(int[] nums, int k) {
        String kString = Integer.toBinaryString(k);
        
        int totalXor = 0;
        
        for (int num : nums) {
            totalXor ^= num;
        }
        
        int ret = 0;
        
        //System.out.println(totalXor);
        
        String xString = Integer.toBinaryString(totalXor);
        
        int bitCount = Math.max(xString.length(), kString.length());
        
        while (xString.length() < bitCount) {
            xString = "0" + xString;
        }
        
        while (kString.length() < bitCount) {
            kString = "0" + kString;
        }
        
        //System.out.println(bitCount);
        
        //System.out.println(kString);
        //System.out.println(xString);
        
        for (int i = bitCount-1; i >= 0; i--) {
            int a = 0;
            int b = 0;
            
            if (i < kString.length()) {
                a = kString.charAt(i)-'0';
            }
            
            if (i < xString.length()) {
                b = xString.charAt(i)-'0';
            }
            
            if (a != b) ret++;
            //System.out.println("a: " + a + " b: " + b);
        }
        
        //int bitCount = 
        return ret;
    }
}