class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int i = 0;
        int totalSum = 0;
        while (i < arr.length) {
            int j = i;
            int sum = arr[j];
            totalSum += sum;
            while (j+2 < arr.length) {
                j += 2;
                sum += arr[j-1];
                sum += arr[j];
                totalSum += sum;
            }
            i++;
        }

        return totalSum;
    }
}