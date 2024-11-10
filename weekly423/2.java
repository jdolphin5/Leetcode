class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int streak = 1;
        int ret = 1;

        Map<Integer, Integer> streakMap = new HashMap<>();
        streakMap.put(0, 1);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1))
                streak++;
            else
                streak = 1;
            // put where streak starts
            streakMap.put(i - streak + 1, streak);
            // System.out.println("x: " + (i-streak+1) + "streak: " + streak);
        }

        for (int i = 0; i < nums.size(); i++) {
            if (!streakMap.containsKey(i))
                continue;
            int val = streakMap.get(i);

            int max = val;
            int sec = streakMap.getOrDefault(i + val, 0);

            // System.out.println("i: " + i + "val: " + val + " sec: " + sec);

            max = Math.min(max, sec);

            ret = Math.max(ret, max);
            ret = Math.max(ret, val / 2);
        }

        return ret;
    }
}