class Solution {
    int[] coins;
    Integer[] cache;

    private int helper(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (cache[amount] != null) return cache[amount];

        int minCoinsChange = Integer.MAX_VALUE;

        for (int coin : coins) {
            int curMinCoinsChange = helper(amount - coin);
            if (curMinCoinsChange != -1) {
                minCoinsChange = Math.min(curMinCoinsChange, minCoinsChange);
            }
        }

        if (minCoinsChange == Integer.MAX_VALUE) {
            minCoinsChange = -1;
        }
        else {
            minCoinsChange += 1;
        }

        cache[amount] = minCoinsChange;
        return cache[amount];

    }

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new Integer[amount + 1];
        return helper(amount);
    }

}