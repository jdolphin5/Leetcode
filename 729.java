class MyCalendar {
    TreeMap<Integer, Integer> intervalMap;

    public MyCalendar() {
        intervalMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer key = intervalMap.floorKey(start);
        Integer endKey = intervalMap.lowerKey(end);

        if ((key != null && intervalMap.get(key) > start) || (endKey != null && endKey > start)) {
            return false;
        }

        intervalMap.put(start, end);
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */