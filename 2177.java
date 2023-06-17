class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 == 0) {
            long[] res = new long[3];
            res[0] = (num/3)-1;
            res[1] = num/3;
            res[2] = (num/3)+1;
            return res;
        }
        return new long[0];
    }
}