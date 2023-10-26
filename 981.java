class TimeMap {
    Map<String, TreeMap<Integer, String>> myMap;

    public TimeMap() {
        myMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> myTreeMap = myMap.getOrDefault(key, new TreeMap<>());
        myTreeMap.put(timestamp, value);
        myMap.put(key, myTreeMap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> myTreeMap = myMap.get(key);

        if (myTreeMap == null) {
            return "";
        }

        Map.Entry<Integer, String> myTreeMapFloorEntry = myTreeMap.floorEntry(timestamp);

        if (myTreeMapFloorEntry == null) {
            return "";
        }

        return myTreeMapFloorEntry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */