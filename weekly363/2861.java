class Solution {
    private boolean canMake(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost, long mid) {
        boolean good = false;
        for (int j = 0; j < composition.size(); j++) {
            long needToPay = 0;
            for (int i = 0; i < stock.size(); i++) {
                long needToBuy = (mid*composition.get(j).get(i))-stock.get(i);
                if (needToBuy > 0)
                    needToPay += needToBuy * cost.get(i);
            }
            //System.out.println("mid: " + mid + " needToPay: " + needToPay);
            if (needToPay <= budget) {
                return true;
            }
        }
        
        return false;
    }
    
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long lower = 0;
        long upper = 200000000;
        
        while (lower < upper) {
            long mid = lower + (upper - lower) / 2;
            if (canMake(n, k, budget, composition, stock, cost, mid)) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }
        
        return canMake(n, k, budget, composition, stock, cost, lower) ? (int)lower : (int)lower-1;
    }
}