class Solution {
    private boolean isGood(int a) {
        boolean diff = false;
        while (a > 0) {
            int x = a % 10;
            if (x == 3 || x == 4 || x == 7) return false;
            if (x == 2 || x == 5 || x == 6 || x == 9) {
                diff = true;
            }
            a /= 10;
        }
        return diff;
    }

    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGood(i)) count++;
        }
        return count;
    }
}