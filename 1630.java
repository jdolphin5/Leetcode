class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ret = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            boolean retBool = true;
            PriorityQueue<Integer> queryPq = new PriorityQueue<>();

            if (r[i] - l[i] == 0) {
                retBool = false;
            }
            else {
                for (int j = l[i]; j <= r[i]; j++) {
                    queryPq.offer(nums[j]);
                }

                int first = queryPq.poll();
                int second = queryPq.poll();
                int diff = second - first;

                while (!queryPq.isEmpty()) {
                    if (queryPq.peek() - second !=  diff) {
                        retBool = false;
                        break;
                    }

                    second = queryPq.poll();
                }
            }
            
            ret.add(retBool);
        }

        return ret;
    }
}