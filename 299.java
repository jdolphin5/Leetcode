class Solution {
    public String getHint(String secret, String guess) {
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();

        int secretCount = 0;
        int cowCount = 0;

        for (int i = 0; i < secretArr.length; i++) {
            //secret matched
            if (secretArr[i] == guessArr[i]) {
                secretCount++;
                secretArr[i] = '\0';
                guessArr[i] = '?';
            }
        }

        for (int i = 0; i < secretArr.length; i++) {
            //check if any guesses match secret digits
            //then set secret digits to null
            for (int j = 0; j < guessArr.length; j++) {
                if (guessArr[j] == secretArr[i]) {
                    secretArr[i] = '\0';
                    guessArr[j] = '?';
                    cowCount++;
                }
            }
        }

        String result = Integer.toString(secretCount) + 'A' + Integer.toString(cowCount) + 'B';


        return result;

    }
}