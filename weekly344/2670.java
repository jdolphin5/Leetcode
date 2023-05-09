class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        
        int[] result = new int[nums.length];
        
        int prefixVal = 0;
        List<Integer> prefix = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> suffix = new ArrayList<>();
            int suffixVal = 0;
            
            if (!prefix.contains(nums[i])) prefixVal++;
            prefix.add(nums[i]);
            
            for (int j = i+1; j < nums.length; j++) {
                if (!suffix.contains(nums[j])) suffixVal++;
                suffix.add(nums[j]);            
            }
            suffix.clear();
            result[i] = prefixVal - suffixVal;
            System.out.println(prefixVal);
            System.out.println(suffixVal);
        }
        
        return result;
    }
}