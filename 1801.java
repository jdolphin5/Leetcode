class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        long ret = 0;
        TreeMap<Integer, Integer> buyMap = new TreeMap<>();
        TreeMap<Integer, Integer> sellMap = new TreeMap<>();
        final int MOD = 1000000007;

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            boolean isBuy = order[2] == 1 ? false : true; // 1 === sell, 0 === buy

            if (isBuy) {
                boolean done = false;

                while (!done) {
                    //try buy all with smallest sell price
                    if (sellMap.size() == 0) {
                        break;
                    }
                    
                    Map.Entry<Integer, Integer> entry = sellMap.firstEntry();
                    int key = entry.getKey();
                    int val = entry.getValue();

                    if (key <= price) {
                        int subtract = Math.min(val, amount);
                        
                        if (val == subtract) {
                            sellMap.remove(key);
                            amount -= subtract;
                        }
                        else {
                            sellMap.put(key, val-subtract);
                            done = true;
                        }
                    }
                    else {
                        break;
                    }
                }

                if (!done) {
                    buyMap.put(price, buyMap.getOrDefault(price, 0) + amount);
                }
            }
            else {
                boolean done = false;

                while (!done) {
                    //try sell all sell with highest buy price
                    if (buyMap.size() == 0) {
                        break;
                    }

                    Map.Entry<Integer, Integer> entry = buyMap.lastEntry();
                    int key = entry.getKey();
                    int val = entry.getValue();

                    if (key >= price) {
                        int subtract = Math.min(val, amount);
                        
                        if (val == subtract) {
                            buyMap.remove(key);
                            amount -= subtract;
                        }
                        else {
                            buyMap.put(key, val-subtract);
                            done = true;
                        }
                    }
                    else {
                        break;
                    }
                }

                if (!done) {
                    sellMap.put(price, sellMap.getOrDefault(price, 0) + amount);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : buyMap.entrySet()) {
            ret += entry.getValue();
            ret %= MOD;
        }

        for (Map.Entry<Integer, Integer> entry : sellMap.entrySet()) {
            ret += entry.getValue();
            ret %= MOD;
        }

        return (int)ret;
    }
}