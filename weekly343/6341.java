class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int perfScoreTimer = 0;
        int sum = 0;
        for (int i = 0; i < player1.length; i++) {
            if (perfScoreTimer > 0) sum = sum + (player1[i] * 2);
            else {
                sum = sum + player1[i];
            }
            if (player1[i] == 10) {
                perfScoreTimer = 3;
            }
            perfScoreTimer = Math.max(perfScoreTimer-1, 0);
        }
        
        int perfScoreTimer2 = 0;
        int sum2 = 0;
        for (int i = 0; i < player2.length; i++) {
            if (perfScoreTimer2 > 0) sum2 = sum2 + (player2[i] * 2);
            else {
                sum2 = sum2 + player2[i];
            }
            if (player2[i] == 10) {
                perfScoreTimer2 = 3;
            }
            perfScoreTimer2 = Math.max(perfScoreTimer2-1, 0);
        }
        
        
        if (sum > sum2) {
            return 1;
        }
        else if (sum == sum2) return 0;
        return 2;
    }
}