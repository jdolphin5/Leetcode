class Solution {
    public int[] closestDivisors(int num) {
        int[] ret = new int[] {1, num+1};

        int minDiff = num;
        int max = (int)Math.ceil(Math.sqrt(num+2));

        for (int i = 1; i <= max; i++) {
            int num1 = num+1;
            int num2 = num+2;

            if (num1 % i == 0) {
                int num3 = num1 / i;

                if (num3 == i) {
                    return new int[] {i, i};
                }

                int diff = num3 - i;
                if (diff < minDiff) {
                    ret[0] = i;
                    ret[1] = num3;
                    minDiff = diff;
                }
            }
            if (num2 % i == 0) {
                int num3 = num2 / i;

                if (num3 == i) {
                    return new int[] {i, i};
                }

                int diff = num3 - i;
                if (diff < minDiff) {
                    ret[0] = i;
                    ret[1] = num3;
                    minDiff = diff;
                }
            }
        }
        
        return ret;
    }
}