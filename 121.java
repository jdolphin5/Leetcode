class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int curLow = prices[0];
        int highestAfterLow = 0;
        int lowestIndex = 0;
        // find lowest price
        for (int i = 1; i < prices.length; i++) {
            if(curLow > prices[i]) {
                System.out.println("New low:" + prices[i]);
                curLow = prices[i];
                lowestIndex = i;
                highestAfterLow = curLow;
            }

            if(prices[i] >= highestAfterLow) {
                    highestAfterLow = prices[i];
                    if ((highestAfterLow - curLow) > result) {
                        result = highestAfterLow - curLow;
                        System.out.println("new result: " + result);
                    }
                }
            }
        return result;
        
    }
}