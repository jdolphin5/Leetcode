class Solution {
    private int calc(int[] threeNums, int n) {
        if (n == 0) {
            return threeNums[2];
        }

        int newNum = threeNums[0] + threeNums[1] + threeNums[2];
        threeNums[0] = threeNums[1];
        threeNums[1] = threeNums[2];
        threeNums[2] = newNum;

        return calc(threeNums, n-1);
    }

    public int tribonacci(int n) {
        int[] threeNums = new int[] {0, 1, 1};

        if (n <= 1) return n;
        if (n == 2) return 1;

        return calc(threeNums, n-2);
    }
}