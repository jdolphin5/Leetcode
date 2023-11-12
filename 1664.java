class Solution {
    public int waysToMakeFair(int[] nums) {
        int ret = 0;

        int[] sumOddBefore = new int[nums.length];
        int[] sumEvenBefore = new int[nums.length];
        int[] sumOddAfter = new int[nums.length];
        int[] sumEvenAfter = new int[nums.length];

        int sumOdd = 0;
        int sumEven = 0;
        int i = 0;

        while (i < nums.length) {
            sumOddBefore[i] = sumOdd;
            sumEvenBefore[i] = sumEven;
            
            if (i % 2 == 0) {
                sumEven += nums[i];
            }
            else {
                sumOdd += nums[i];
            }

            i++;
        }

        sumOdd = 0;
        sumEven = 0;
        i = nums.length-1;

        while (i >= 0) {
            sumOddAfter[i] = sumOdd;
            sumEvenAfter[i] = sumEven;
            
            if (i % 2 == 0) {
                sumEven += nums[i];
            }
            else {
                sumOdd += nums[i];
            }

            i--;
        }

        for (int j = 0; j < nums.length; j++) {
            //System.out.println((sumOddBefore[j] + sumEvenAfter[j]) + " : " + (sumEvenBefore[j] + sumOddAfter[j]));
            if ((sumOddBefore[j] + sumEvenAfter[j]) == (sumEvenBefore[j] + sumOddAfter[j])) {
                ret++;
            }
        }

        return ret;
    }
}