class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ret = -1;
        int ready = 0;
        int money = 0;
        int max = 0;
        int i = 0;

        while (money >= 0 || i < customers.length) {
            if (i < customers.length)
                ready += customers[i];
            int toRide = Math.min(ready, 4);
            ready -= toRide;
            money = money + (toRide * boardingCost) - runningCost;

            if (max < money) {
                max = money;
                ret = i+1;
            }

            i++;
        }

        return ret;
    }
}