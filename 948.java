class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0;
        int j = tokens.length-1;

        Arrays.sort(tokens);

        int maxScore = 0;
        int score = 0;
        while (i <= j) {
            if (power < tokens[i]) {
                if(score >= 1) {
                    score--;
                    power += tokens[j];
                    j--;
                }
                else {
                    break;
                }
            }
            else {
                score++;
                power -= tokens[i];
                i++;
            }
            //System.out.println(score);
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }
}