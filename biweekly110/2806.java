class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int subtract = 0;
        if (purchaseAmount % 10 >= 5) {
            subtract = 10;
        }
        return 100 - subtract - ((purchaseAmount) - (purchaseAmount%10));
    }
}