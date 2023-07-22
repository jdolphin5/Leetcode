class Solution {
    public int maximizeGreatness(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        int i = 0;
        while (!pq.isEmpty()) {
            if (pq.poll() > nums[i]) {
                ret++;
                i++;
            }
        }
        return ret;
    }
}