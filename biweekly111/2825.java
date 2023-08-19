class Solution {
    private boolean canMake(Boolean[] dp, String str1, String str2, int i, int j) {
        if (j == str2.length()) return true;
        if (i == str1.length()) return false;
        if (dp[i] != null) {
            return dp[i];
        }
        
        char characterPlus = '%';
        
        if (str1.charAt(i) < 'z') {
            characterPlus = str1.charAt(i);
            characterPlus += 1;
        }
        else if (str1.charAt(i) == 'z')
            characterPlus = 'a';
        
        if (str1.charAt(i) == str2.charAt(j) || characterPlus == str2.charAt(j)) {
            dp[i] = canMake(dp, str1, str2, i+1, j+1); 
        }
        else {
            dp[i] = canMake(dp, str1, str2, i+1, j);
        }
        return dp[i];
    }
    
    public boolean canMakeSubsequence(String str1, String str2) {
        Boolean[] dp = new Boolean[str1.length()];
        return canMake(dp, str1, str2, 0, 0);
    }
}