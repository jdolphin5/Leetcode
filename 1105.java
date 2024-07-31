class Solution {
    private int recur(Integer[][] dp, int[][] books, int width, int i, int curHeight, int curThickness) {
        if (i == books.length) {
            return curHeight;
        }

        if (dp[i][curThickness] != null) {
            return dp[i][curThickness];
        }

        int thickness = books[i][0];
        int height = books[i][1];

        int newShelf = curHeight + recur(dp, books, width, i+1, height, thickness);

        int sameShelf = Integer.MAX_VALUE;

        if (width >= curThickness + thickness) {
            sameShelf = recur(dp, books, width, i+1, Math.max(curHeight, height), curThickness + thickness);
        }

        return dp[i][curThickness] = Math.min(newShelf, sameShelf);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer[][] dp = new Integer[books.length][shelfWidth+1];
        
        return recur(dp, books, shelfWidth, 0, 0, 0);
    }
}