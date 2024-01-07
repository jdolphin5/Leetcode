class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Map<Integer, Integer> myMap1 = new HashMap<>();
        Map<Integer, Integer> myMap2 = new HashMap<>();
        
        //anything that occurs more than once can be deleted
        //if it occurs once in both, could be deleted from whichever
        //if it occurs once in one, try leave it
        
        for (int num : nums1) {
            myMap1.put(num, myMap1.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            myMap2.put(num, myMap2.getOrDefault(num, 0) + 1);
        }
        
        int n = nums1.length;
        int leftRem = n / 2;
        int rightRem = n / 2;
        
        //reduce map1 to unique keys
        for (Map.Entry<Integer, Integer> entry : myMap1.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val > 1) {
                leftRem -= val - 1;
                myMap1.put(key, 1);
            }
        }
        
        //reduce map2 to unique keys
        for (Map.Entry<Integer, Integer> entry : myMap2.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val > 1) {
                rightRem -= val - 1;
                myMap2.put(key, 1);
            }
        }
        
        //reduce map1 to keys that are not in map2
        if (leftRem > 0) {
            for (Map.Entry<Integer, Integer> entry : myMap1.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();

                if (myMap2.get(key) != null) {
                    System.out.println(key);
                    leftRem--;
                    myMap1.put(key, 0);
                }
                
                if (leftRem == 0) break;
            }
        }
        
        //System.out.println(leftRem);
        
        //reduce map1 remaining keys until left remaining is 0
        if (leftRem > 0) {
            for (Map.Entry<Integer, Integer> entry : myMap1.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();

                if (val == 0) continue;
                
                leftRem--;
                myMap1.put(key, 0);
                
                if (leftRem == 0) break;
            }
        }
        
        //System.out.println(leftRem);
        //System.out.println(myMap1.toString());
        
        //remove all in right map that remain in left
        for (Map.Entry<Integer, Integer> entry : myMap1.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val == 0) continue;

            int rightCt = myMap2.getOrDefault(key, 0);
            rightRem -= rightCt;
            if (rightCt > 0)
                myMap2.put(key, 0);
        }
        
        System.out.println(rightRem);
        System.out.println(myMap2.toString());
        
        
        //remove until right remaining is 0
        for (Map.Entry<Integer, Integer> entry : myMap2.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val == 0) continue;
            
            if (rightRem > 0) {
                rightRem--;
                myMap2.put(key, 0);
            }
            else break;
        }
        
        //System.out.println(rightRem);
        //System.out.println(myMap2.toString());
        
        Map<Integer, Integer> myMap3 = new HashMap<>();
        
        for (Map.Entry<Integer, Integer> entry : myMap1.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val > 0) {
                myMap3.put(key, val);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : myMap2.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val > 0) {
                myMap3.put(key, val);
            }
        }
        
        return myMap3.size();
    }
}