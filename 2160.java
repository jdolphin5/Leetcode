class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        int x = 0;
        while (x < 4) {
            digits[x] = num % 10;
            num /= 10;
            x++;
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int num1 = digits[i];
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                int num2 = digits[j];
                boolean found = false;
                int num3 = 0;
                int num4 = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j && k != i) {
                        num3 = digits[k];
                        for (int l = 0; l < 4; l++) {
                            if (l != j && l != i && l != k) {
                                num4 = digits[l];
                                minSum = Math.min(minSum, (num1 * 10) + num2 + (num3 * 10) + num4);
                            }
                        }
                    }
                }
            }
        }
        return minSum;

    }
}