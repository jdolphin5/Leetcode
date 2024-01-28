class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int ret = 0;
        Map<Integer, Queue<Integer>> qMap = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            if (!qMap.containsKey(nums.get(i))) {
                qMap.put(nums.get(i), new LinkedList<>());
            }
            Queue<Integer> q = qMap.get(nums.get(i));
            q.offer(i);

            while (i - q.peek() + 1 > q.size() + k) {
                q.poll();
            }

            ret = Math.max(ret, q.size());
        }

        return ret;
    }
}
