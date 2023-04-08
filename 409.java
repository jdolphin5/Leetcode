class Solution {
    
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char myChar: s.toCharArray()) {
            map.put(myChar, map.getOrDefault(myChar, 0) + 1);
        }

        int result = 0;
        boolean odd = false;
        for(int count: map.values()) {
            if (count % 2 == 0) result += count;
            else {
                odd = true;
                result += count - 1;
            }
        }
        if (odd) result++;
        return result;
    }
}