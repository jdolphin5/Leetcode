class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        // System.out.println(Arrays.deepToString(queries));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int i = 0;
        int j = 0;

        while (i < nums.length) {
            while (j < queries.length && queries[j][0] == i) {
                pq.offer(queries[j]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < i) {
                pq.poll();
            }

            nums[i] -= pq.size();
            // System.out.println("i: " + i + "nums[i]: " + nums[i]);
            i++;
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0)
                return false;
        }

        return true;
    }
}