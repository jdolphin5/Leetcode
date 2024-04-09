class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        boolean cont = true;
        int ret = 0;

        while (cont) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] >= 1)
                    ret++;
                tickets[i]--;
                if (i == k && tickets[i] == 0)
                    return ret;
            }
        }

        return -1;
    }
}