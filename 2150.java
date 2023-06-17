class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] bucket = new int[1000001];
        for (int num : nums) {
            bucket[num]++;
        }
        for (int i = 1; i < bucket.length-1; i++) {
            if (bucket[i] == 1 && bucket[i-1] == 0 && bucket[i+1] == 0) {
                res.add(i);
            }
        }
        if (bucket[0] == 1 && bucket[1] == 0) res.add(0);

        if (bucket[bucket.length-1] == 1 && bucket[bucket.length-2] == 0) res.add(bucket.length-1);

        return res;

    }
}