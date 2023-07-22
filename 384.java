class Solution {
    int[] originalNums, shuffleNums;

    public Solution(int[] nums) {
        originalNums = nums.clone();
        shuffleNums = nums.clone();
    }
    
    public int[] reset() {
        shuffleNums = originalNums.clone();
        return originalNums;
    }
    
    public int[] shuffle() {
        int n = shuffleNums.length;
        for (int i = 0; i < n; i++) {
            int randomNum = new Random().nextInt(n);
            int temp = shuffleNums[i];
            shuffleNums[i] = shuffleNums[randomNum];
            shuffleNums[randomNum] = temp;
        }
        return shuffleNums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */