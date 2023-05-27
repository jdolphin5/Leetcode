class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;

        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(area, max);
            if (height[i] < height[j]) {
                i++;
            }
            else if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
                j--;
            }
        }
        return max;
    }
}