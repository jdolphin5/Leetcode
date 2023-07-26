class Solution {
    public int fillCups(int[] amount) {
        int ret = 0;
        Arrays.sort(amount);
        while (amount[2] > 0) {
            int count = 2;
            for (int i = amount.length-1; i >= 0; i--) {
                if (count > 0)
                    amount[i]--;
                count--;
            }
            ret++;
            Arrays.sort(amount);
        }
        return ret;

    }
}