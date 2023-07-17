class NumberContainers {
    Map<Integer, Integer> numAtIndexMap;
    Map<Integer, TreeSet<Integer>> indicesOfNumberMap;

    public NumberContainers() {
        numAtIndexMap = new HashMap<>();
        indicesOfNumberMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        int last = numAtIndexMap.getOrDefault(index, -1);
        numAtIndexMap.put(index, number);
        if (last != -1) {
            TreeSet<Integer> myTree = indicesOfNumberMap.get(last);
            myTree.remove(Integer.valueOf(index));
            indicesOfNumberMap.put(last, myTree);
        }
        TreeSet<Integer> myTree = indicesOfNumberMap.getOrDefault(number, new TreeSet<>());
        myTree.add(index);
        indicesOfNumberMap.put(number, myTree);
    }
    
    public int find(int number) {
        TreeSet<Integer> myTree = indicesOfNumberMap.getOrDefault(number, new TreeSet<>());
        if (myTree.size() == 0) return -1;
        return myTree.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */