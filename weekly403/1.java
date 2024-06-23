class Solution {
    public double minimumAverage(int[] nums) {
        List<Double> avgList = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length / 2; i++) {
            avgList.add(((double)nums[i] + (double)nums[nums.length-1-i]) / 2.0);
        }
        
        Collections.sort(avgList);
        
        return avgList.get(0);
    }
}