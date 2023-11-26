class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    matrix[i][j] = matrix[i-1][j] + 1;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int area = 0;
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.offer(matrix[i][j]);
            }

            while (!pq.isEmpty()) {
                int cur = pq.peek();
                area = cur * pq.size();
                maxArea = Math.max(maxArea, area);
                pq.poll();
            }
        }

        return maxArea;
    }
}