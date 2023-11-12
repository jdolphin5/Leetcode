class StockPrice {
    TreeMap<Integer, Integer> curPriceTreeMap;
    TreeMap<Integer, Integer> freqPriceTreeMap;

    public StockPrice() {
        curPriceTreeMap = new TreeMap<>();
        freqPriceTreeMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        int last = curPriceTreeMap.getOrDefault(timestamp, -1);

        if (last != -1) {
            freqPriceTreeMap.put(last, freqPriceTreeMap.get(last) - 1);
            if (freqPriceTreeMap.get(last) == 0) {
                freqPriceTreeMap.remove(last);
            }
        }

        curPriceTreeMap.put(timestamp, price);

        freqPriceTreeMap.put(price, freqPriceTreeMap.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return curPriceTreeMap.lastEntry().getValue();
    }
    
    public int maximum() {
        return freqPriceTreeMap.lastKey();
    }
    
    public int minimum() {
        return freqPriceTreeMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */