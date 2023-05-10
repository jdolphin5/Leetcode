class Solution {

    private String reverse(String sub) {
        char[] res = sub.toCharArray();
        for (int i = 0; i < res.length/2; i++) {
            char temp = res[i];
            res[i] = res[res.length-1-i];
            res[res.length-1-i] = temp;
        }
        return String.valueOf(res);
    }

    public String reverseStr(String s, int k) {
        int count = k;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (count == k) {
                if (i+k >= s.length()) k = s.length()-i;
                result += reverse(s.substring(i, i+k));
                count = 0;
                i = i+k-1;
            }
            else {
                result += s.charAt(i);
                count++;
            } 
        }
        return result;
    }
}