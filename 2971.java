class Solution {
    public long largestPerimeter(int[] nums) {
        int i = 0;
        int j = 0;
        int x = 0;

        Arrays.sort(nums);

        long ret = -1;
        long sumOfSides = 0;
        boolean cont = true;

        while (cont && j < nums.length && x < nums.length) {
            cont = false;
            
            if (x < j) {
                cont = true;
                x = j;
            }
            if (sumOfSides > nums[x]) {
                cont = true;
                ret = Math.max(ret, sumOfSides + nums[x]);
                x++;
            }
            if (j - i <= 1 || (x < nums.length && sumOfSides <= nums[x]) || cont) {
                cont = true;
                sumOfSides += nums[j];
                j++;
            }
        }

        return ret;
    }
}