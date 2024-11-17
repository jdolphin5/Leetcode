class Solution {
    private boolean check(int[][] queriesWithIndex, int[] nums, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int i = 0;
        int j = 0;
        int sum = 0;

        while (i < nums.length) {

            while (j < queriesWithIndex.length && queriesWithIndex[j][0] == i) {
                if (queriesWithIndex[j][3] <= x) {
                    pq.offer(queriesWithIndex[j]);
                    sum += queriesWithIndex[j][2];
                }

                j++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < i) {
                int[] pollQuery = pq.poll();
                sum -= pollQuery[2];
            }

            nums[i] -= sum;

            i++;
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0)
                return false;
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        boolean checkInit = true;

        for (int num : nums) {
            if (num != 0) {
                checkInit = false;
                break;
            }
        }

        if (checkInit)
            return 0;

        int[][] queriesWithIndex = new int[queries.length][4];

        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
        }

        Arrays.sort(queriesWithIndex, (a, b) -> a[0] - b[0]);

        int lower = 0;
        int upper = queries.length;
        boolean found = false;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            // System.out.println("mid: " + mid + "upper: " + upper);

            if (check(queriesWithIndex, nums.clone(), mid)) {
                // System.out.println("good");
                upper = mid;
                found = true;
            } else {
                lower = mid + 1;
            }
        }

        return check(queriesWithIndex, nums.clone(), upper) ? upper + 1 : -1;
    }
}