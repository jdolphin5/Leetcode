class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;
        int right = cardPoints.length-k;

        //add all k cards from right
        for (int i = cardPoints.length-1; i > cardPoints.length-k-1; i--) {
            sum += cardPoints[i];
        }
        max = Math.max(max, sum);

        //remove deepest right one and add next left one
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[right+i];
            sum += cardPoints[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}