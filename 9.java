class Solution {
    public boolean isPalindrome(int x) {
        String myString = String.valueOf(x);
        int length = myString.length();
        
        for (int i = 0; i < length/2; i++) {
            if (myString.charAt(i) != myString.charAt(length-i-1)) return false;
        }

        return true;
    }
}