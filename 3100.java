class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ret = 0;
        int numEmptyBottles = 0;
        boolean continueBool = true;
        
        while (continueBool) {
            continueBool = false;
            ret += numBottles;
            numEmptyBottles += numBottles;
            numBottles = 0;
            
            if (numEmptyBottles - numExchange >= 0) {
                numBottles++;
                numEmptyBottles -= numExchange;
                numExchange++;
                continueBool = true;
            }
        }
        
        return ret;
    }
}