class Solution {
    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> losers = new HashSet<>();
        HashSet<Integer> winners = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            losers.add(i);
        }
        
        int cur = 1;
        int step = 1;
        while (!winners.contains(cur)) {
            winners.add(cur);
            if (losers.contains(cur)) {
                losers.remove(cur);
            }
            System.out.println(cur);
            cur += k * step;
            step++;
            while (cur > n) {
                cur = cur - n; 
            }
        }
        int i = 0;
        int[] answer = new int[losers.size()];
        for (int num : losers) {
            answer[i++] = num;
        }
        return answer;
    }
}