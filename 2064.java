class Solution {
    private boolean canMake(int mid, int n, int[] quantities) {
        int x = 0;

        for (int num : quantities) {
            int val = (int) Math.ceil((double)num/mid);
            x += val;
        }

        return x <= n;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        
        for (int num : quantities) {
            max = Math.max(max, num);
        }

        int upper = max;
        int lower = 1;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (canMake(mid, n, quantities)) {
                upper = mid;
            }
            else {
                lower = mid+1;
            }
        }

        return lower;
    }
}