class Solution {
    int maxPts = 0;
    int[] bobArr = new int[12];

    private void dfs(int arrowsLeft, int roundPtr, int[] bobArrows, int[] aliceArrows, int bobPts) {
        if (arrowsLeft >= 0 && roundPtr > -1) {
            bobArrows[roundPtr] = 0;
            dfs(arrowsLeft, roundPtr-1, bobArrows, aliceArrows, bobPts);
            if (arrowsLeft >= aliceArrows[roundPtr]+1) {
                bobArrows[roundPtr] = aliceArrows[roundPtr]+1;
                dfs(arrowsLeft - bobArrows[roundPtr], roundPtr-1, bobArrows, aliceArrows, roundPtr+bobPts); 
            }
        }
        else {
            if (arrowsLeft > 0) bobArrows[0] += arrowsLeft;
            if (bobPts > maxPts) {
                maxPts = bobPts;
                bobArr = bobArrows.clone();
            }
            return;
        }
    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bobArrows = new int[12];
        dfs(numArrows, 11, bobArrows, aliceArrows, 0);
        return bobArr;
    }
}