class Solution {
    public int maximumProduct(int[] nums, int k) {
        long result = 1;
        int mod = (int)Math.pow(10,9) + 7;

        PriorityQueue<Integer> myHeap = new PriorityQueue<>();
        for (int i = nums.length-1; i >=0; i--) {
            myHeap.add(nums[i]);
        }

        while (k > 0) {
            int val = myHeap.poll();
            k--;
            myHeap.add(++val);
        }

        while (!myHeap.isEmpty()) {
            int val = myHeap.poll();
                result = (result * val) % mod;
        }
        return (int)(result);
    }
}