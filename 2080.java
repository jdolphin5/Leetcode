class RangeFreqQuery {
    Map<Integer, List<Integer>> indicesOfValueMap;

    public RangeFreqQuery(int[] arr) {
        indicesOfValueMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> myList = indicesOfValueMap.getOrDefault(arr[i], new ArrayList<>());
            myList.add(i);
            indicesOfValueMap.put(arr[i], myList);
        }    
    }
    
    public int query(int left, int right, int value) {
        List<Integer> myList = indicesOfValueMap.getOrDefault(value, new ArrayList<>());
        if (myList == null) return 0;

        int leftPtr = -1;
        int rightPtr = -1;

        int lower = 0;
        int upper = myList.size();

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (myList.get(mid) < left) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }

        leftPtr = lower;

        lower = 0;
        upper = myList.size();

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if (myList.get(mid) <= right) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }

        rightPtr = lower;

        return rightPtr - leftPtr;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */