class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        
        int n = nums.size();
        List<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);
        
        boolean equal2 = true;
        for (int x = 0; x < nums.size(); x++) {
            if (sortedNums.get(x) != nums.get(x)) {
                equal2 = false;
            }
        }
        if (equal2) return 0;
        
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> numsCopy = new ArrayList<>(nums);
            List<Integer> newList = new ArrayList<>();
            for (int j = n-2-i; j < 2*n-2-i; j++) {
                newList.add(numsCopy.get((n+j+1)%n));
            }
            
            //System.out.println(newList.toString());
            
            boolean equal = true;
            for (int x = 0; x < nums.size(); x++) {
                if (sortedNums.get(x) != newList.get(x)) {
                    equal = false;
                }
            }
            if (equal) return i+1;
        }
        
        return -1;
        
        
    }
}