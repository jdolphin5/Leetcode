class Solution {
    public boolean divideArray(int[] nums) {
        int[] bucket = new int[501];
        for (int num : nums) {
            bucket[num]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] % 2 != 0) return false;
        }
        return true;
    }
}