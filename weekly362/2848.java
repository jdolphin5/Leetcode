class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] line = new int[101];
        int count = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = nums.get(i).get(0); j <= nums.get(i).get(nums.get(i).size()-1); j++) {
                line[j] = 1;
            }
        }
        
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 1) {
                count++;
            }
        }
        
        return count;
    }
}