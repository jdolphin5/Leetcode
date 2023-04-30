class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Set<Character> mySet = new HashSet<>();
        int maxLength = 0;

        int i = 0;
        int j = 0;

        while (j < s.length()) {

            while (mySet.contains(s.charAt(j))) {
                mySet.remove(s.charAt(i));
                i++;
            }
            
            mySet.add(s.charAt(j));
            j++;
            maxLength = Math.max(maxLength, j - i);
        }

        return maxLength;
    }
}