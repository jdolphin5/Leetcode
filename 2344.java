class Solution {
    private int gcd (int a, int b) {
        if (a % b == 0)
            return b;
        
        return gcd(b, a % b);
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0];

        for (int i = 1; i < numsDivide.length; i++) {
            g = gcd(g, numsDivide[i]);
        }

        Arrays.sort(nums);

        int ret = 0;

        for (int num : nums) {
            if (g % num != 0) {
                ret++;
            }
            else {
                break;
            }
        }

        return ret == nums.length ? -1 : ret;
    }
}