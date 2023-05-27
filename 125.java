class Solution {
    private boolean isPal(String myString) {
        for (int i = 0; i < myString.length()/2; i++) {
            if (myString.charAt(i) != myString.charAt(myString.length()-i-1)) return false;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        String myString = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i))) {
                myString += Character.toLowerCase(s.charAt(i));
            }
        }
        return isPal(myString);
    }
}