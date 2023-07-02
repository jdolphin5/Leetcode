class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        int count = 0;
        for (int num : arr) {
            sum += num;
        }

        int avg = sum / 3;

        int part = 0;
        for (int num : arr) {
            part += num;
            if (part == avg) {
                count++;
                part = 0;
            }
        }
        return count >= 3 && sum % 3 == 0;
    }
}