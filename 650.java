public class Solution {
    private int recur(int x, int n, int copied) {
        if (x > n) {
            return 5000;
        }

        if (x == n) {
            return 0;
        }

        int paste = 5000;
        int copy = 5000;

        if (copied != 0)
            paste = 1 + recur(x+copied, n, copied);

        if (copied != x)
            copy = 1 + recur(x, n, x);

        return Math.min(paste, copy);
    }

    public int minSteps(int n) {
        return recur(1, n, 0);
    }
} 650 {
    
}
