class FrequencyTracker {
    
    //works but terrible implementation - counts of arrays better e.g:
    //int[] fs = new int[100001];
    //int[] rfs = new int[1000000];
    
    Map<Integer, Integer> myMap = new HashMap<>();
    Map<Integer, Integer> invMap = new HashMap<>();

    public FrequencyTracker() {
        
    }
    
    public void add(int number) {
        int freq = myMap.getOrDefault(number, 0) + 1;
        myMap.put(number, freq);
        int count = invMap.getOrDefault(freq, 0) + 1;
        invMap.put(freq, count);
        if (invMap.containsKey(freq-1)) {
            if (invMap.get(freq-1) > 0)
                invMap.put(freq-1, invMap.get(freq-1)-1);
        }
        //System.out.println("add: " + invMap.get(1));
    }
    
    public void deleteOne(int number) {
        if (!myMap.containsKey(number)) return;
        
        
        int count = invMap.get(myMap.get(number));
        invMap.put(myMap.get(number), count-1);
        //increment invMap count of frequency-1
        if(invMap.containsKey(myMap.get(number)-1)) {
            invMap.put(myMap.get(number)-1, invMap.get(myMap.get(number)-1) + 1);
            //System.out.println("test");
        }
        
        //System.out.println("delete: " + invMap.get(1));
        if (myMap.get(number) == 1) {
            myMap.remove(number);
            return;
        }
        myMap.put(number, myMap.get(number) - 1);
    }
    
    public boolean hasFrequency(int frequency) {
        if (invMap.containsKey(frequency) && invMap.get(frequency) > 0) return true;
        return false;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */