class Solution {
    public String getHint(String secret, String guess) {
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();
        int[] secretArrCount = new int[10];
        int[] guessArrCount = new int[10];

        int secretCount = 0;
        int cowCount = 0;

        for (int i = 0; i < secretArr.length; i++) {
            //secret matched
            if (secretArr[i] == guessArr[i]) {
                secretCount++;
            }
            else {
                secretArrCount[secretArr[i]-'0']++;
                guessArrCount[guessArr[i]-'0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cowCount += Math.min(secretArrCount[i], guessArrCount[i]);
        }


        return secretCount + "A" + cowCount + "B";

    }
}