class Solution {
    public String decodeAtIndex(String s, int k) {
        long length = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                //System.out.println("length:" + length + " s.charAt(i): " + s.charAt(i));
                length *= s.charAt(i)-'0';
                //System.out.println("length:" + length + " s.charAt(i): " + s.charAt(i));
            }
            else {
                length++;
            }
            //System.out.println(length);
        }



        String ret = "";

        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                length /= c-'0';
                k %= length;
            }
            else {
                if (k == 0 || length == k)
                    return new String(String.valueOf(c));
                length--;                    
            }
            //System.out.println(c);
        }

        return "";
    }
}