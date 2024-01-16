class RandomizedSet {
    List<Integer> myList;

    public RandomizedSet() {
        myList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (!myList.contains(val)) {
            myList.add(val);
            return true;
        }

        return false;
    }
    
    public boolean remove(int val) {
        if (myList.remove(new Integer(val))) {
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        Random rand = new Random();
        
        return myList.get(rand.nextInt(myList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */