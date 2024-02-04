class Solution {
    public boolean canSortArray(int[] nums) {
        List<List<Integer>> groupList = new ArrayList<>();
        List<Integer> group = new ArrayList<>();
        group.add(0);
        
        for (int i = 0; i < nums.length-1; i++) {
            if ((int)Integer.bitCount(nums[i]) == (int)Integer.bitCount(nums[i+1])) {
                group.add(i+1);
            }
            else {
                groupList.add(group);
                group = new ArrayList<>();
                group.add(i+1);
            }
        }
        
        groupList.add(group);
        
        Map<Integer, Integer> indexToGroupMap = new HashMap<>();
        
        for (int i = 0; i < groupList.size(); i++) {
            for (int j = 0; j < groupList.get(i).size(); j++) {
                if (indexToGroupMap.get(nums[groupList.get(i).get(j)]) != null) {
                    if (indexToGroupMap.get(nums[groupList.get(i).get(j)]) != i) {
                        return false;
                    }
                }
                indexToGroupMap.put(nums[groupList.get(i).get(j)], i);
            }
        }
        
        //System.out.println(indexToGroupMap.toString());
        
        int[] numsCopy = nums.clone();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (!indexToGroupMap.get(nums[i]).equals(indexToGroupMap.get(numsCopy[i]))) {
                //System.out.println(i);
                return false;
            }
        }
        
        return true;
        
        
    }
}