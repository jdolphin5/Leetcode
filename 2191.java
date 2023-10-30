public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] mappedArr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            int mappedNum = 0;
            int j = 1;

            mappedArr[i][1] = nums[i];

            if (nums[i] == 0) {
                mappedArr[i][0] = mapping[0];
                continue;
            }

            while (nums[i] > 0) {
                int cur = nums[i] % 10;
                mappedNum += j * mapping[cur];
                nums[i] /= 10;
                j *= 10;
            }

            mappedArr[i][0] = mappedNum;
        }

        Arrays.sort(mappedArr, (a, b) -> a[0] - b[0]);

        int[] ret = new int[nums.length];

        for (int i = 0; i < mappedArr.length; i++) {
            ret[i] = mappedArr[i][1];
        }

        return ret;
    }
} 2191 {
    
}
