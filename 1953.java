class Solution {
    public long numberOfWeeks(int[] milestones) {

        long sum = 0;
        int max = 0;
        for (int num : milestones) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        sum = sum-max;
        sum += Math.min(max, sum+1);
        return sum;
    }
}