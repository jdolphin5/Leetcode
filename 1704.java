class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        Set<Character> mySet = new HashSet<>();
        mySet.add('a');
        mySet.add('e');
        mySet.add('i');
        mySet.add('o');
        mySet.add('u');
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length()/2; i++) {
            if (mySet.contains(s.charAt(i))) left++;
            if (mySet.contains(s.charAt(i+(s.length()/2)))) right++;
        }
        return left == right;
    }
}