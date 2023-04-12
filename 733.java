class Solution {

    private void fill (int[][] image, int sr, int sc, int color, int originalColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originalColor) return;
        image[sr][sc] = color;
        fill(image, sr-1, sc, color, originalColor);
        fill(image, sr+1, sc, color, originalColor);
        fill(image, sr, sc-1, color, originalColor);
        fill(image, sr, sc+1, color, originalColor);
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        fill (image, sr, sc, color, image[sr][sc]);

        return image;
    }
}