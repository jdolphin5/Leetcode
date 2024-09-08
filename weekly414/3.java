class Solution {
    private class Value {
        int val;
        int i;

        private Value(int val, int i) {
            this.val = val;
            this.i = i;
        }
    }

    public long findMaximumScore(List<Integer> nums) {
        int[] numsArr = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            numsArr[i] = nums.get(i);
        }

        if (numsArr.length == 1)
            return 0;

        long ret = 0;
        PriorityQueue<Value> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        pq.offer(new Value(numsArr[0], 0));

        for (int i = 1; i < numsArr.length; i++) {
            if (numsArr[i] > pq.peek().val || i == numsArr.length-1) {
                ret += 1L * pq.peek().val * (i - pq.peek().i);
            }

            pq.offer(new Value(numsArr[i], i));
        }

        return ret;
    }
}