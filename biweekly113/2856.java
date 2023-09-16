class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int count = 0;
        boolean isOdd = false;
        
        if (nums.size() == 1) {
            return 1;
        }
        
        if (nums.size() % 2 == 1) {
            isOdd = true;
        }
        
        //System.out.println("go");
        
        
        for (int i = 0; i < nums.size()/2; i++) {
            int j = nums.size()/2+i;
            if (isOdd) j++;
            if (nums.get(i) >= nums.get(j)) { //== does not work as it checks pointer of Integer are equal, not the value
                count+=2;
            }
            //System.out.println(nums.get(i) + " : " + nums.get(j));
        }
        
        if (isOdd) {
            count++;
        }
        
        return count;
    }
}