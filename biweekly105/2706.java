class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int init = money;
        money -= prices[0];
        money -= prices[1];
        if (money >= 0) return money;
        return init;
    }
}