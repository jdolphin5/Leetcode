class Solution {
    private boolean canMake(int check, int[] position, int m) {
        int last = Integer.MIN_VALUE;
        int count = 0;
        
        for (int i = 0; i < position.length; i++) {
            if (position[i] >= last + check) {
                last = position[i];
                count++;
            }
        }

        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int lower = 0;
        int upper = position[position.length-1];

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (canMake(mid, position, m)) {
                lower = mid+1;
            }
            else {
                upper = mid-1;
            }
        }

        return canMake(lower, position, m) ? lower : lower-1;
    }
}